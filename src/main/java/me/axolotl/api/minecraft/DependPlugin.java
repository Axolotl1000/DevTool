package me.axolotl.api.minecraft;

/**
 * The DependPlugin class represents a dependency plugin.
 *
 * @since 2024-04-18
 */
public class DependPlugin {

    private final String pluginID;
    private final boolean force;

    /**
     * Constructs a new DependPlugin with the specified plugin ID and force flag.
     *
     * @param pluginID the ID of the dependent plugin
     * @param force    a boolean indicating whether the dependency is forced
     */
    public DependPlugin(String pluginID, boolean force) {
        this.pluginID = pluginID;
        this.force = force;
    }

    /**
     * Retrieves the ID of the dependent plugin.
     *
     * @return the ID of the dependent plugin
     */
    public String getPluginID() {
        return pluginID;
    }

    /**
     * Checks if the dependency is forced.
     *
     * @return true if the dependency is forced, false otherwise
     */
    public boolean isForce() {
        return force;
    }

    /**
     * Returns a string representation of the DependPlugin.
     *
     * @return a string representation of the DependPlugin
     */
    @Override
    public String toString() {
        return "DependPlugin{" +
                "pluginID='" + pluginID + '\'' +
                ", force=" + force +
                '}';
    }
}

