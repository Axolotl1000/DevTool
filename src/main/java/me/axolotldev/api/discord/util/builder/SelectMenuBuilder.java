package me.axolotldev.api.discord.util.builder;

import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * SelectMenuBuilder類提供了一個用於構建帶有選項的選擇選單的模板。
 *
 * @since 2024-02-22
 */

@SuppressWarnings("unused")
public abstract class SelectMenuBuilder {

    private final String id;
    private final List<SelectOption> options = new ArrayList<>();
    private boolean disable;
    private int minValue;
    private int maxValue;

    /**
     * 使用指定的ID構造一個新的SelectMenuBuilder。
     *
     * @param id 選擇選單的ID
     */
    public SelectMenuBuilder(String id) {
        this(id, null, false, 1, 1);
    }

    /**
     * 使用指定的ID和選項構造一個新的SelectMenuBuilder。
     *
     * @param id      選擇選單的ID
     * @param options 選擇選單的選項
     */
    public <T extends List<SelectOption>> SelectMenuBuilder(String id, T options) {
        this(id, options, false, 1, 1);
    }

    /**
     * 使用指定的ID、選項和禁用狀態構造一個新的SelectMenuBuilder。
     *
     * @param id      選擇選單的ID
     * @param options 選擇選單的選項
     * @param disable 選擇選單的禁用狀態
     */
    public <T extends List<SelectOption>> SelectMenuBuilder(String id, T options, boolean disable) {
        this(id, options, disable, 1, 1);
    }

    /**
     * 使用指定的ID、選項、禁用狀態、最小值和最大值構造一個新的SelectMenuBuilder。
     *
     * @param id       選擇選單的ID
     * @param options  選擇選單的選項
     * @param disable  選擇選單的禁用狀態
     * @param minValue 選擇選單的允許的最小值
     * @param maxValue 選擇選單的允許的最大值
     */
    public <T extends List<SelectOption>> SelectMenuBuilder(String id, T options, boolean disable, int minValue, int maxValue) {
        this.id = id;
        this.options.addAll(options);
        this.disable = disable;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * 獲取選擇選單的ID。
     *
     * @return 選擇選單的ID
     */
    public String getId() {
        return id;
    }

    /**
     * 啟用選擇選單。
     */
    public void asEnable() {
        this.disable = false;
    }

    /**
     * 禁用選擇選單。
     */
    public void asDisable() {
        this.disable = true;
    }

    /**
     * 設置允許選擇的最小值。
     *
     * @param minValue 允許選擇的最小值
     */
    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    /**
     * 設置允許選擇的最大值。
     *
     * @param maxValue 允許選擇的最大值
     */
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * 獲取選擇選單的選項。
     *
     * @return 選擇選單的選項列表
     */
    public List<SelectOption> getOptions() {
        return options;
    }

    /**
     * 根據ID獲取選項。
     *
     * @param id 選項的ID
     * @return 具有指定ID的選項的文本
     */
    @Nullable
    public SelectOption getOptionById(String id) {
        for (SelectOption so : options) {
            if (so.getLabel().equalsIgnoreCase(id)) {
                return so;
            }
        }
        return null;
    }

    /**
     * 獲取表示選擇選單的SelectMenu對象。
     *
     * @return 表示選擇選單的SelectMenu對象
     */
    public StringSelectMenu getMenu() {
        SelectMenu.Builder<StringSelectMenu, StringSelectMenu.Builder> builder = StringSelectMenu.create(id)
                .addOptions(options)
                .setMinValues(minValue)
                .setMaxValues(maxValue)
                .setDisabled(disable);

        return builder.build();
    }

    /**
     * 指定當從選擇選單中選擇一個選項時要執行的操作。
     *
     * @param event 表示選擇選項的事件
     */
    public abstract void onSelected(StringSelectInteractionEvent event);

}
