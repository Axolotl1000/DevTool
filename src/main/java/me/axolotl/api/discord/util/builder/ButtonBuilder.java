package me.axolotl.api.discord.util.builder;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;
import net.dv8tion.jda.internal.interactions.component.ButtonImpl;

/**
 * The ButtonBuilder class is an abstract class for building buttons with various styles and properties.
 *
 * @since 2024-02-22
 */
public abstract class ButtonBuilder {

    private final String id;
    private ButtonStyle style;
    private String name;
    private Emoji emoji;
    private boolean disable = false;

    /**
     * Constructs a new ButtonBuilder with the specified ID.
     *
     * @param id the ID of the button
     */
    public ButtonBuilder(String id) {
        this(id, null, ButtonStyle.PRIMARY, null);
    }

    /**
     * Constructs a new ButtonBuilder with the specified ID, name, and style.
     *
     * @param id    the ID of the button
     * @param name  the name of the button
     * @param style the style of the button
     */
    public ButtonBuilder(String id, String name, ButtonStyle style) {
        this(id, name, style, null);
    }

    /**
     * Constructs a new ButtonBuilder with the specified ID, name, style, and emoji.
     *
     * @param id    the ID of the button
     * @param name  the name of the button
     * @param style the style of the button
     * @param emoji the emoji associated with the button
     */
    public ButtonBuilder(String id, String name, ButtonStyle style, Emoji emoji) {
        this.id = id;
        this.name = name;
        this.emoji = emoji;
        this.style = style;
    }

    /**
     * Enables the button.
     */
    public void asEnable() {
        this.disable = false;
    }

    /**
     * Disables the button.
     */
    public void asDisable() {
        this.disable = true;
    }

    /**
     * Sets the name of the button.
     *
     * @param name the name of the button
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the emoji associated with the button.
     *
     * @param emoji the emoji associated with the button
     */
    public void setEmoji(Emoji emoji) {
        this.emoji = emoji;
    }

    /**
     * Changes the style of the button.
     *
     * @param style the new style of the button
     */
    public void changeStyle(ButtonStyle style) {
        this.style = style;
    }

    /**
     * Builds and returns the button.
     *
     * @return the built button
     */
    public Button getButton() {
        return new ButtonImpl(id, name, style, disable, emoji);
    }

    /**
     * Gets the ID of the button.
     *
     * @return the ID of the button
     */
    public String getId() {
        return this.id;
    }

    /**
     * Handles button press events.
     *
     * @param event the button interaction event
     */
    public abstract void onPress(ButtonInteractionEvent event);
}
