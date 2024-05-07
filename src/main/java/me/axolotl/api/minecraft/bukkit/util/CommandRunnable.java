package me.axolotl.api.minecraft.bukkit.util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * CommandRunnable類提供了一個模板，用於創建Bukkit/Spigot指令及其Tab自動補全。
 *
 * <br>
 * 使用{@link me.axolotl.api.minecraft.bungee.util.CommandRunnable}創建BungeeCord的指令
 *
 * @since 2024-02-08
 */
public abstract class CommandRunnable implements CommandExecutor, TabExecutor {

    private final String commandName;

    /**
     * 使用指定的指令名構造一個CommandRunnable。
     *
     * @param commandName 指令的名稱。
     */
    public CommandRunnable(String commandName) {
        this.commandName = commandName;
    }

    /**
     * 獲取指令的名稱。
     *
     * @return 指令的名稱。
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
     * 執行指令。
     *
     * @param sender  指令發送者。
     * @param command 正在執行的指令。
     * @param s       指令的標籤。
     * @param args    傳遞給指令的參數。
     * @return 如果成功執行了指令則返回true，否則返回false。
     */
    public abstract boolean execute(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args);

    /**
     * 為指令提供Tab自動補全。
     *
     * @param sender  指令發送者。
     * @param command 正在Tab自動補全的指令。
     * @param s       指令的標籤。
     * @param args    傳遞給指令的參數。
     * @return Tab自動補全選項的列表。
     */
    public abstract List<String> tab(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args);

}
