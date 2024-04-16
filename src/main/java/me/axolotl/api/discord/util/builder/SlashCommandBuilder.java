package me.axolotl.api.discord.util.builder;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.DiscordLocale;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * The SlashCommandBuilder class provides a template for building slash commands.
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
     * Constructs a new SlashCommandBuilder with the specified name and description.
     *
     * @param name        the name of the slash command
     * @param description the description of the slash command
     */
    public SlashCommandBuilder(String name, String description) {
        this(name, description, Collections.emptyList(), Map.of(), Map.of());
    }

    /**
     * Constructs a new SlashCommandBuilder with the specified name, description, and options.
     *
     * @param name        the name of the slash command
     * @param description the description of the slash command
     * @param options     the options of the slash command
     */
    public SlashCommandBuilder(String name, String description, List<OptionData> options) {
        this(name, description, options, Map.of(), Map.of());
    }

    /**
     * Constructs a new SlashCommandBuilder with the specified name, description, options, and name localizations.
     *
     * @param name              the name of the slash command
     * @param description       the description of the slash command
     * @param options           the options of the slash command
     * @param nameLocalizations the name localizations of the slash command
     */
    public SlashCommandBuilder(String name, String description, List<OptionData> options, Map<DiscordLocale, String> nameLocalizations) {
        this(name, description, options, nameLocalizations, Map.of());
    }

    /**
     * Constructs a new SlashCommandBuilder with the specified name, description, options, name localizations, and description localizations.
     *
     * @param name                     the name of the slash command
     * @param description              the description of the slash command
     * @param options                  the options of the slash command
     * @param nameLocalizations        the name localizations of the slash command
     * @param descriptionLocalizations the description localizations of the slash command
     */
    public SlashCommandBuilder(String name, String description, List<OptionData> options, Map<DiscordLocale, String> nameLocalizations, Map<DiscordLocale, String> descriptionLocalizations) {
        this.name = name;
        this.description = description;
        this.options.addAll(options);
        this.nameLocalizations.putAll(nameLocalizations);
        this.descriptionLocalizations.putAll(descriptionLocalizations);
    }

    /**
     * Gets the SlashCommandData object representing the slash command.
     *
     * @return the SlashCommandData object representing the slash command
     */
    @NotNull
    public final SlashCommandData getCommand() {
        return Commands.slash(name, description).addOptions(options).setNameLocalizations(nameLocalizations).setDescriptionLocalizations(descriptionLocalizations);
    }

    /**
     * Gets the name of the slash command.
     *
     * @return the name of the slash command
     */
    @NotNull
    public final String getName() {
        return name;
    }

    /**
     * Specifies the action to be performed when the slash command is submitted.
     *
     * @param event the event representing the submission of the slash command
     */
    public abstract void onSubmit(SlashCommandInteractionEvent event);

}

