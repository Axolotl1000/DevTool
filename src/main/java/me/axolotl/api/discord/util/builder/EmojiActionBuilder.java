package me.axolotl.api.discord.util.builder;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

/**
 * EmojiActionBuilder類提供了一個基於表情符號反應的操作構建模板。
 *
 * @since 2024-02-22
 */
public abstract class EmojiActionBuilder {

    /**
     * 與操作關聯的表情符號。
     */
    public final Emoji emoji;

    /**
     * 用指定的表情符號構造一個新的EmojiActionBuilder。
     *
     * @param emoji 表情符號字符串
     */
    public EmojiActionBuilder(String emoji) {
        this.emoji = Emoji.fromUnicode(emoji);
    }

    /**
     * 用指定的表情符號構造一個新的EmojiActionBuilder。
     *
     * @param emoji 表情符號的Emoji對象
     */
    public EmojiActionBuilder(Emoji emoji) {
        this.emoji = emoji;
    }

    /**
     * 獲取與操作關聯的表情符號。
     *
     * @return 表情符號
     */
    public Emoji getEmoji() {
        return emoji;
    }

    /**
     * 指定在選擇表情符號時要執行的操作。
     *
     * @param event 表示添加反應的事件
     */
    public abstract void onSelect(MessageReactionAddEvent event);

    /**
     * 指定在取消選擇表情符號時要執行的操作。
     *
     * @param event 表示移除反應的事件
     */
    public abstract void onUnselect(MessageReactionRemoveEvent event);
}
