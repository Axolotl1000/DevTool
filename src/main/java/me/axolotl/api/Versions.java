package me.axolotl.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Versions類提供了代表各種API版本的常量。
 *
 * @since 2024-02-08
 */
public final class Versions {

    private Versions() {
    }

    /**
     * 此應用程序的API版本。
     */
    public static final Map<String, String> dependencies = dependencies();

    private static Map<String, String> dependencies() {
        Map<String, String> ds = new HashMap<>();

        ds.put("current", "2.1");
        ds.put("org.spigotmc.spigot-api", "1.20.4-R0.1-SNAPSHOT");
        ds.put("net.md-5.bungeecord-api", "1.20-R0.2");
        ds.put("net.dv8tion.JDA", "5.0.0-beta.22");
        ds.put("org.xerial.sqlite-jdbc", "3.45.2.0");
        ds.put("org.jetbrains.annotations", "24.1.0");

        return ds;
    }

}
