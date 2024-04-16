package me.axolotl.api.minecraft.bungee.util;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * The CommandRunnable class provides a template for creating commands with tab completion.
 * <br>
 * For Bukkit? Use {@link me.axolotl.api.minecraft.bukkit.util.CommandRunnable}
 *
 * @since 2024-02-08
 */
public abstract class CommandRunnable extends Command implements TabExecutor {

    /**
     * Constructs a CommandRunnable with the specified name.
     *
     * @param name The name of the command.
     */
    public CommandRunnable(String name) {
        super(name);
    }

    /**
     * Constructs a CommandRunnable with the specified name, and permission.
     *
     * @param name       The name of the command.
     * @param permission The permission required to execute the command.
     */
    public CommandRunnable(String name, String permission) {
        super(name, permission);
    }

    /**
     * Constructs a CommandRunnable with the specified name, permission, and aliases.
     *
     * @param name       The name of the command.
     * @param permission The permission required to execute the command.
     * @param aliases    Any aliases for the command.
     */
    public CommandRunnable(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }

    @Override
    public final void execute(CommandSender commandSender, String[] strings) {
        run(commandSender, strings);
    }

    @Override
    public final Iterable<String> onTabComplete(CommandSender commandSender, String[] strings) {
        return tab(commandSender, strings);
    }

    /**
     * Executes the command.
     *
     * @param sender The command sender.
     * @param args   The command arguments.
     */
    public abstract void run(CommandSender sender, String[] args);

    /**
     * Provides tab completion for the command.
     *
     * @param sender The command sender.
     * @param args   The command arguments.
     * @return A list of tab completion options.
     */
    @Nullable
    public abstract List<String> tab(CommandSender sender, String[] args);
}
