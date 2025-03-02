package me.axolotldev.api.discord.util.builder;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.DiscordLocale;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * SlashCommandBuilder類提供了一個用於構建斜槓指令的模板。
 *
 * @since 2024-02-22
 */
public abstract class SlashCommandBuilder {

    private final String name;
    private final String description;
    private final List<OptionData> options = new ArrayList<>();
    private final Map<DiscordLocale, String> nameLocalizations = new HashMap<>();
    private final Map<DiscordLocale, String> descriptionLocalizations = new HashMap<>();

    /**
     * 使用指定的名稱和描述構造一個新的SlashCommandBuilder。
     *
     * @param name        斜槓指令的名稱
     * @param description 斜槓指令的描述
     */
    public SlashCommandBuilder(String name, String description) {
        this(name, description, Collections.emptyList(), Map.of(), Map.of());
    }

    /**
     * 使用指定的名稱、描述和選項構造一個新的SlashCommandBuilder。
     *
     * @param name        斜槓指令的名稱
     * @param description 斜槓指令的描述
     * @param options     斜槓指令的選項
     */
    public SlashCommandBuilder(String name, String description, List<OptionData> options) {
        this(name, description, options, Map.of(), Map.of());
    }

    /**
     * 使用指定的名稱、描述、選項和名稱本地化構造一個新的SlashCommandBuilder。
     *
     * @param name              斜槓指令的名稱
     * @param description       斜槓指令的描述
     * @param options           斜槓指令的選項
     * @param nameLocalizations 斜槓指令的名稱本地化
     */
    public SlashCommandBuilder(String name, String description, List<OptionData> options, Map<DiscordLocale, String> nameLocalizations) {
        this(name, description, options, nameLocalizations, Map.of());
    }

    /**
     * 使用指定的名稱、描述、選項、名稱本地化和描述本地化構造一個新的SlashCommandBuilder。
     *
     * @param name                     斜槓指令的名稱
     * @param description              斜槓指令的描述
     * @param options                  斜槓指令的選項
     * @param nameLocalizations        斜槓指令的名稱本地化
     * @param descriptionLocalizations 斜槓指令的描述本地化
     */
    public SlashCommandBuilder(String name, String description, List<OptionData> options, Map<DiscordLocale, String> nameLocalizations, Map<DiscordLocale, String> descriptionLocalizations) {
        this.name = name;
        this.description = description;
        this.options.addAll(options);
        this.nameLocalizations.putAll(nameLocalizations);
        this.descriptionLocalizations.putAll(descriptionLocalizations);
    }

    /**
     * 獲取表示斜槓指令的SlashCommandData對象。
     *
     * @return 表示斜槓指令的SlashCommandData對象
     */
    @NotNull
    public final SlashCommandData getCommand() {
        return Commands.slash(name, description).addOptions(options).setNameLocalizations(nameLocalizations).setDescriptionLocalizations(descriptionLocalizations);
    }

    /**
     * 獲取斜槓指令的名稱。
     *
     * @return 斜槓指令的名稱
     */
    @NotNull
    public final String getName() {
        return name;
    }

    /**
     * 指定當提交斜槓指令時要執行的操作。
     *
     * @param event 表示提交斜槓指令的事件
     */
    public abstract void onSubmit(SlashCommandInteractionEvent event);

}
