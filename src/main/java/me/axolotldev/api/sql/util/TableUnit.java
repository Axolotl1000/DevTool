package me.axolotldev.api.sql.util;

import me.axolotldev.api.sql.enumerate.TableDataInfo;
import me.axolotldev.api.sql.enumerate.TableType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * TableUnit類表示數據庫表的單元，包含其ID、類型和相關的數據信息。
 *
 * @since 2024-02-24
 */
public final class TableUnit {

    private final String id;
    private final TableType type;
    private final List<TableDataInfo> info = new ArrayList<>();

    /**
     * 使用指定的ID、類型和數據信息構造一個新的TableUnit。
     *
     * @param id   表單元的ID
     * @param type 表單元的類型
     * @param info 表單元相關的數據信息
     */
    public TableUnit(@NotNull String id, @NotNull TableType type, @NotNull TableDataInfo... info) {
        this.id = id;
        this.type = type;
        this.info.addAll(List.of(info));
    }

    /**
     * 返回TableUnit對象的字符串表示形式。
     *
     * @return 對象的字符串表示形式
     */
    @Override
    public String toString() {
        ArrayList<String> command = new ArrayList<>(List.of(this.id, this.type.name()));

        this.info.forEach(info -> command.add(info.toString()));

        return String.join(" ", command);
    }

}
