package me.axolotldev.api.discord.util.builder;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;
import net.dv8tion.jda.internal.interactions.component.ButtonImpl;

/**
 * ButtonBuilder類是一個抽象類，用於構建具有各種風格和屬性的按鈕。
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
     * 用指定的ID構造一個新的ButtonBuilder。
     *
     * @param id 按鈕的ID
     */
    public ButtonBuilder(String id) {
        this(id, null, ButtonStyle.PRIMARY, null);
    }

    /**
     * 用指定的ID，名稱和樣式構造一個新的ButtonBuilder。
     *
     * @param id    按鈕的ID
     * @param name  按鈕的名稱
     * @param style 按鈕的樣式
     */
    public ButtonBuilder(String id, String name, ButtonStyle style) {
        this(id, name, style, null);
    }

    /**
     * 用指定的ID，名稱，樣式和表情符號構造一個新的ButtonBuilder。
     *
     * @param id    按鈕的ID
     * @param name  按鈕的名稱
     * @param style 按鈕的樣式
     * @param emoji 與按鈕關聯的表情符號
     */
    public ButtonBuilder(String id, String name, ButtonStyle style, Emoji emoji) {
        this.id = id;
        this.name = name;
        this.emoji = emoji;
        this.style = style;
    }

    /**
     * 啟用按鈕。
     */
    public void asEnable() {
        this.disable = false;
    }

    /**
     * 禁用按鈕。
     */
    public void asDisable() {
        this.disable = true;
    }

    /**
     * 設置按鈕的名稱。
     *
     * @param name 按鈕的名稱
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 設置與按鈕關聯的表情符號。
     *
     * @param emoji 與按鈕關聯的表情符號
     */
    public void setEmoji(Emoji emoji) {
        this.emoji = emoji;
    }

    /**
     * 更改按鈕的樣式。
     *
     * @param style 按鈕的新樣式
     */
    public void changeStyle(ButtonStyle style) {
        this.style = style;
    }

    /**
     * 構建並返回按鈕。
     *
     * @return 構建的按鈕
     */
    public Button getButton() {
        return new ButtonImpl(id, name, style, disable, emoji);
    }

    /**
     * 獲取按鈕的ID。
     *
     * @return 按鈕的ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * 處理按鈕按下事件。
     *
     * @param event 按鈕交互事件
     */
    public abstract void onPress(ButtonInteractionEvent event);
}
