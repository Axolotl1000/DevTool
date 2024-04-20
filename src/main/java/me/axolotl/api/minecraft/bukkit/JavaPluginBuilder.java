package me.axolotl.api.minecraft.bukkit;

import me.axolotl.api.exception.ChecksNotPassException;
import me.axolotl.api.minecraft.DependPlugin;
import me.axolotl.api.minecraft.bukkit.util.CommandRunnable;
import me.axolotl.api.tool.Checks;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.logging.Logger;

/**
 * The JavaPluginBuilder class is an abstract class that extends {@link JavaPlugin} and provides methods for building Bukkit/Spigot plugins.
 * <br />
 * For BungeeCord? Use {@link me.axolotl.api.minecraft.bungee.BungeePluginBuilder}
 *
 * @since 2024-02-08
 */
public abstract class JavaPluginBuilder extends JavaPlugin {

    private final Logger logger = getLogger();

    /**
     * Called when the plugin is being loaded.
     */
    @Override
    public final void onLoad() {
        logger.info("Loading Plugin: " + getPluginName());
        runOnLoading();
        logger.info("Loaded Plugin: " + getPluginName());
    }

    /**
     * Called when the plugin is being enabled.
     */
    @Override
    public final void onEnable() {
        logger.info("Enabling Plugin: " + getPluginName());
        runOnEnable();

        boolean anyForceNInstall = false;

        for (DependPlugin dp : getDependencies()){
            try {
                Checks.IsNull(getServer().getPluginManager().getPlugin(dp.getPluginID()), dp.getPluginID());
            } catch (ChecksNotPassException ignored) {
                if (dp.isForce()) {
                    logger.severe( dp.getPluginID() + " is a required plug-in, but it is not installed.");
                    anyForceNInstall = true;
                } else {
                    logger.warning(dp.getPluginID() + " is not installed, but is not necessary.");
                }
            }
        }

        if(anyForceNInstall) {
            logger.severe("The necessary plugin is not installed, so the plugin cannot be enabled");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        for (CommandRunnable cmd : getCommands()) {
            PluginCommand pc = getCommand(cmd.getCommandName());
            if (pc == null) {
                logger.warning("Cannot find command: " + cmd.getCommandName());
                logger.warning("Is it already set in plugin.yml?");
                continue;
            }
            pc.setExecutor(cmd);
            pc.setTabCompleter(cmd);
        }
        for (Listener l : getEvents()) {
            getServer().getPluginManager().registerEvents(l, this);
        }
        logger.info("Enabled Plugin: " + getPluginName());
    }

    /**
     * Called when the plugin is being disabled.
     */
    @Override
    public final void onDisable() {
        logger.info("Disabling Plugin: " + getPluginName());
        runOnDisable();
        logger.info("Disabled Plugin: " + getPluginName());
    }

    /**
     * Retrieves the name of the plugin.
     *
     * @return the name of the plugin
     */
    public abstract @NotNull String getPluginName();

    /**
     * Retrieves a list of commands associated with the plugin.
     *
     * @return a list of commands
     */
    public abstract @NotNull List<CommandRunnable> getCommands();

    /**
     * Retrieves a list of event listeners associated with the plugin.
     *
     * @return a list of event listeners
     */
    public abstract @NotNull List<Listener> getEvents();

    /**
     * Retrieves a list of dependencies with the plugin.
     *
     * @return a list of depend on Plugins
     */
    public abstract @NotNull List<DependPlugin> getDependencies();

    /**
     * Runs custom tasks when the plugin is being loaded.
     */
    public void runOnLoading() {
    }

    /**
     * Runs custom tasks when the plugin is being enabled.
     */
    public void runOnEnable() {
    }

    /**
     * Runs custom tasks when the plugin is being disabled.
     */
    public void runOnDisable() {
    }

}

