package me.axolotl.api.discord.util.builder;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

/**
 * The EmojiActionBuilder class provides a template for building actions based on emoji reactions.
 *
 * @since 2024-02-22
 */
public abstract class EmojiActionBuilder {

    /**
     * The emoji associated with the action.
     */
    public final Emoji emoji;

    /**
     * Constructs a new EmojiActionBuilder with the specified emoji.
     *
     * @param emoji the emoji string
     */
    public EmojiActionBuilder(String emoji) {
        this.emoji = Emoji.fromUnicode(emoji);
    }

    /**
     * Constructs a new EmojiActionBuilder with the specified emoji.
     *
     * @param emoji the Emoji object representing the emoji
     */
    public EmojiActionBuilder(Emoji emoji) {
        this.emoji = emoji;
    }

    /**
     * Gets the emoji associated with the action.
     *
     * @return the emoji
     */
    public Emoji getEmoji() {
        return emoji;
    }

    /**
     * Specifies the action to be performed when the emoji is selected.
     *
     * @param event the event representing the addition of the reaction
     */
    public abstract void onSelect(MessageReactionAddEvent event);

    /**
     * Specifies the action to be performed when the emoji is unselected.
     *
     * @param event the event representing the removal of the reaction
     */
    public abstract void onUnselect(MessageReactionRemoveEvent event);
}

