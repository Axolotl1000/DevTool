package me.axolotldev.api.minecraft.bukkit;

import me.axolotldev.api.exception.ChecksNotPassException;
import me.axolotldev.api.minecraft.DependPlugin;
import me.axolotldev.api.minecraft.bukkit.util.CommandRunnable;
import me.axolotldev.api.tool.Checks;
import me.axolotldev.api.minecraft.bungee.BungeePluginBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.logging.Logger;

/**
 * JavaPluginBuilder類別是一個抽象類別，擴展自{@link org.bukkit.plugin.java.JavaPlugin}，並提供了構建Bukkit/Spigot插件的方法。
 * <br />
 * 使用{@link BungeePluginBuilder}創建BungeeCord插件
 *
 * @since 2024-02-08
 */
@SuppressWarnings("unused")
public abstract class JavaPluginBuilder extends JavaPlugin {

    private final Logger logger = getLogger();

    /**
     * 當插件正在加載時調用。
     */
    @Override
    public final void onLoad() {
        logger.info("Loading Plugin: " + getPluginName());
        runOnLoading();
        logger.info("Loaded Plugin: " + getPluginName());
    }

    /**
     * 當插件啟用時調用。
     */
    @Override
    public final void onEnable() {
        logger.info("Enabling Plugin：" + getPluginName());
        runOnEnable();

        boolean anyForceNInstall = false;

        for (DependPlugin dp : getDependencies()){
            try {
                Checks.IsNull(getServer().getPluginManager().getPlugin(dp.pluginID()), dp.pluginID());
            } catch (ChecksNotPassException ignored) {
                if (dp.force()) {
                    logger.severe( dp.pluginID() + " is a required plug-in, but it is not installed.");
                    anyForceNInstall = true;
                } else {
                    logger.warning(dp.pluginID() + " is not installed, but is not necessary.");
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
     * 當插件停用時調用。
     */
    @Override
    public final void onDisable() {
        logger.info("Disabling Plugin: " + getPluginName());
        runOnDisable();
        logger.info("Disabled Plugin: " + getPluginName());
    }

    /**
     * 獲取插件名稱。
     *
     * @return 插件的名稱
     */
    public abstract @NotNull String getPluginName();

    /**
     * 獲取與插件關聯的指令列表。
     *
     * @return 指令列表
     */
    public abstract @NotNull List<CommandRunnable> getCommands();

    /**
     * 獲取與插件關聯的事件監聽器列表。
     *
     * @return 事件監聽器列表
     */
    public abstract @NotNull List<Listener> getEvents();

    /**
     * 獲取與插件有關的依賴列表。
     *
     * @return 依賴的插件列表
     */
    public abstract @NotNull List<DependPlugin> getDependencies();

    /**
     * 當插件正在加載時運行自定義任務。
     */
    public void runOnLoading() {
    }

    /**
     * 當插件正在啟用時運行自定義任務。
     */
    public void runOnEnable() {
    }

    /**
     * 當插件正在停用時運行自定義任務。
     */
    public void runOnDisable() {
    }

}
