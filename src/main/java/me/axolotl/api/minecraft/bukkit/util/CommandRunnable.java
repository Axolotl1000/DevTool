package me.axolotl.api.minecraft.bukkit.util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * The CommandRunnable class provides a template for creating Bukkit/Spigot commands with tab completion.
 *
 * <br>
 * For BungeeCord? Use {@link me.axolotl.api.minecraft.bungee.util.CommandRunnable}
 *
 * @since 2024-02-08
 */
public abstract class CommandRunnable implements CommandExecutor, TabExecutor {

    private final String commandName;

    /**
     * Constructs a CommandRunnable with the specified command name.
     *
     * @param commandName The name of the command.
     */
    public CommandRunnable(String commandName) {
        this.commandName = commandName;
    }

    /**
     * Retrieves the name of the command.
     *
     * @return The name of the command.
     */
    public String getCommandName() {
        return commandName;
    }

    @Override
    public final boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        return execute(sender, command, s, args);
    }

    @Nullable
    @Override
    public final List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        return tab(sender, command, s, args);
    }

    /**
     * Executes the command.
     *
     * @param sender  The command sender.
     * @param command The command being executed.
     * @param s       The label of the command.
     * @param args    The arguments passed to the command.
     * @return true if the command was executed successfully, false otherwise.
     */
    public abstract boolean execute(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args);

    /**
     * Provides tab completion for the command.
     *
     * @param sender  The command sender.
     * @param command The command being tab completed.
     * @param s       The label of the command.
     * @param args    The arguments passed to the command.
     * @return A list of tab completion options.
     */
    public abstract List<String> tab(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args);

}

