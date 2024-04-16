package me.axolotl.api.minecraft.bungee.util;

import net.md_5.bungee.api.plugin.Listener;

import java.util.ArrayList;
import java.util.List;

/**
 * The PluginBuildInfo class represents information about a plugin build, such as its name, events, commands,
 * and enable/disable actions.
 * For BungeeCord? Use {@link me.axolotl.api.minecraft.bukkit.util.PluginBuildInfo}
 *
 * @since 2024-02-08
 * @deprecated in 2024-04-13
 */
@Deprecated(since = "2024-04-13", forRemoval = true)
public final class PluginBuildInfo {

    private String pluginName;
    private List<Listener> events = new ArrayList<>();
    private List<CommandRunnable> commands = new ArrayList<>();
    private Runnable onEnable = () -> {
    };
    private Runnable onDisable = () -> {
    };

    /**
     * Constructs a PluginBuildInfo object with the specified plugin name.
     *
     * @param pluginName The name of the plugin.
     */
    public PluginBuildInfo(String pluginName) {
        this.pluginName = pluginName;
    }

    /**
     * Sets the plugin name.
     *
     * @param pluginName The name of the plugin.
     * @return This PluginBuildInfo instance.
     */
    public PluginBuildInfo setPluginName(String pluginName) {
        this.pluginName = pluginName;
        return this;
    }

    /**
     * Sets the events for the plugin.
     *
     * @param events The list of events.
     * @return This PluginBuildInfo instance.
     */
    public PluginBuildInfo setEvents(Listener... events) {
        this.events = List.of(events);
        return this;
    }

    /**
     * Sets the commands for the plugin.
     *
     * @param commands The list of command runnables.
     * @return This PluginBuildInfo instance.
     */
    public PluginBuildInfo setCommands(CommandRunnable... commands) {
        this.commands = List.of(commands);
        return this;
    }

    /**
     * Sets the action to be performed on plugin enable.
     *
     * @param onEnable The action to be performed.
     * @return This PluginBuildInfo instance.
     */
    public PluginBuildInfo setOnEnable(Runnable onEnable) {
        this.onEnable = onEnable;
        return this;
    }

    /**
     * Sets the action to be performed on plugin disable.
     *
     * @param onDisable The action to be performed.
     * @return This PluginBuildInfo instance.
     */
    public PluginBuildInfo setOnDisable(Runnable onDisable) {
        this.onDisable = onDisable;
        return this;
    }

    /**
     * Retrieves the plugin name.
     *
     * @return The name of the plugin.
     */
    public String getPluginName() {
        return pluginName;
    }

    /**
     * Retrieves the list of events.
     *
     * @return The list of events.
     */
    public List<Listener> getEvents() {
        return events;
    }

    /**
     * Retrieves the list of commands.
     *
     * @return The list of commands.
     */
    public List<CommandRunnable> getCommands() {
        return commands;
    }

    /**
     * Retrieves the action to be performed on plugin enable.
     *
     * @return The action to be performed.
     */
    public Runnable getOnEnable() {
        return onEnable;
    }

    /**
     * Retrieves the action to be performed on plugin disable.
     *
     * @return The action to be performed.
     */
    public Runnable getOnDisable() {
        return onDisable;
    }
}
