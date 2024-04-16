package me.axolotl.api.discord.util.builder;

import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The SelectMenuBuilder class provides a template for building select menus with options.
 *
 * @since 2024-02-22
 */
public abstract class SelectMenuBuilder {

    private final String id;
    private final HashMap<String, String> options = new HashMap<>();
    private boolean disable;
    private int minValue;
    private int maxValue;

    /**
     * Constructs a new SelectMenuBuilder with the specified ID.
     *
     * @param id the ID of the select menu
     */
    public SelectMenuBuilder(String id) {
        this(id, null, false, 1, 1);
    }

    /**
     * Constructs a new SelectMenuBuilder with the specified ID and options.
     *
     * @param id      the ID of the select menu
     * @param options the options of the select menu
     */
    public SelectMenuBuilder(String id, HashMap<String, String> options) {
        this(id, options, false, 1, 1);
    }

    /**
     * Constructs a new SelectMenuBuilder with the specified ID, options, and disable status.
     *
     * @param id      the ID of the select menu
     * @param options the options of the select menu
     * @param disable the disable status of the select menu
     */
    public SelectMenuBuilder(String id, HashMap<String, String> options, boolean disable) {
        this(id, options, disable, 1, 1);
    }

    /**
     * Constructs a new SelectMenuBuilder with the specified ID, options, disable status, minimum value, and maximum value.
     *
     * @param id       the ID of the select menu
     * @param options  the options of the select menu
     * @param disable  the disable status of the select menu
     * @param minValue the minimum value allowed for selection
     * @param maxValue the maximum value allowed for selection
     */
    public SelectMenuBuilder(String id, HashMap<String, String> options, boolean disable, int minValue, int maxValue) {
        this.id = id;
        this.options.putAll(options);
        this.disable = disable;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * Gets the ID of the select menu.
     *
     * @return the ID of the select menu
     */
    public String getId() {
        return id;
    }

    /**
     * Enables the select menu.
     */
    public void asEnable() {
        this.disable = false;
    }

    /**
     * Disables the select menu.
     */
    public void asDisable() {
        this.disable = true;
    }

    /**
     * Sets the minimum value allowed for selection.
     *
     * @param minValue the minimum value allowed for selection
     */
    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    /**
     * Sets the maximum value allowed for selection.
     *
     * @param maxValue the maximum value allowed for selection
     */
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Gets the options of the select menu.
     *
     * @return a list of select options
     */
    public List<SelectOption> getOptions() {
        List<SelectOption> options = new ArrayList<>();

        this.options.forEach((i, d) -> options.add(SelectOption.of(i, d)));

        return options;
    }

    /**
     * Gets the option by its ID.
     *
     * @param id the ID of the option
     * @return the text of the option with the specified ID
     */
    public String getOptionById(String id) {
        return this.options.getOrDefault(id, "");
    }

    /**
     * Gets the SelectMenu object representing the select menu.
     *
     * @return the SelectMenu object representing the select menu
     */
    public StringSelectMenu getMenu() {
        List<SelectOption> options = new ArrayList<>();

        this.options.forEach((i, d) -> options.add(SelectOption.of(d, i)));
        SelectMenu.Builder<StringSelectMenu, StringSelectMenu.Builder> builder = StringSelectMenu.create(id)
                .addOptions(options)
                .setMinValues(minValue)
                .setMaxValues(maxValue)
                .setDisabled(disable);

        return builder.build();
    }

    /**
     * Specifies the action to be performed when an option is selected from the select menu.
     *
     * @param event the event representing the selection of an option
     */
    public abstract void onSelected(StringSelectInteractionEvent event);

}

