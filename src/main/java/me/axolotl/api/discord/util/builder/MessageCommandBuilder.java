package me.axolotl.api.discord.util.builder;

import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.interactions.DiscordLocale;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * MessageCommandBuilder類提供了一個用於構建訊息指令的模板。
 *
 * @since 2024-05-09
 */
public abstract class MessageCommandBuilder {

    private final String name;
    private final Map<DiscordLocale, String> nameLocalizations = new HashMap<>();

    /**
     * 使用指定的名稱和描述構造一個新的MessageCommandBuilder。
     *
     * @param name        訊息指令的名稱
     */
    public MessageCommandBuilder(String name) {
        this(name, Map.of());
    }

    /**
     * 使用指定的名稱和描述構造一個新的MessageCommandBuilder。
     *
     * @param name        訊息指令的名稱
     * @param nameLocalizations 訊息指令的名稱本地化
     */
    public MessageCommandBuilder(String name, Map<DiscordLocale, String> nameLocalizations) {
        this.name = name;
        this.nameLocalizations.putAll(nameLocalizations);
    }

    /**
     * 獲取指令資料。
     *
     * @return {@link CommandData} 指令資料。
     */
    @NotNull
    public final CommandData getCommand() {
        return Commands.message(name).setNameLocalizations(nameLocalizations);
    }

    /**
     * 獲取指令名稱。
     *
     * @return 指令名稱。
     */
    @NotNull
    public final String getName() {
        return name;
    }

    /**
     * 當互動觸發時的處理方法。
     *
     * @param event 互動事件的上下文。
     */
    public abstract void onInteraction(@NotNull MessageContextInteractionEvent event);
}

