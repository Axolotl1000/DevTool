package me.axolotldev.api.minecraft.bungee.util;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * CommandRunnable類別提供了一個模板，用於創建具有Tab補全的指令。
 * <br>
 * 使用{@link me.axolotldev.api.minecraft.bukkit.util.CommandRunnable}創建Bukkit/Spigot的指令
 *
 * @since 2024-02-08
 */
@SuppressWarnings("unused")
public abstract class CommandRunnable extends Command implements TabExecutor {

    /**
     * 使用指定的名稱構造一個CommandRunnable。
     *
     * @param name 指令的名稱。
     */
    public CommandRunnable(String name) {
        super(name);
    }

    /**
     * 使用指定的名稱和權限構造一個CommandRunnable。
     *
     * @param name       指令的名稱。
     * @param permission 執行該指令所需的權限。
     */
    public CommandRunnable(String name, String permission) {
        super(name, permission);
    }

    /**
     * 使用指定的名稱、權限和別名構造一個CommandRunnable。
     *
     * @param name       指令的名稱。
     * @param permission 執行該指令所需的權限。
     * @param aliases    指令的任何別名。
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
     * 執行指令。
     *
     * @param sender 指令發送者。
     * @param args   指令參數。
     */
    public abstract void run(CommandSender sender, String[] args);

    /**
     * 為指令提供Tab補全。
     *
     * @param sender 指令發送者。
     * @param args   指令參數。
     * @return Tab補全選項的列表。
     */
    @Nullable
    public abstract List<String> tab(CommandSender sender, String[] args);
}
