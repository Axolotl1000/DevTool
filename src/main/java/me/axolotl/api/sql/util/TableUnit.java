package me.axolotl.api.sql.util;

import me.axolotl.api.sql.enumerate.TableDataInfo;
import me.axolotl.api.sql.enumerate.TableType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * The TableUnit class represents a unit of a database table, containing its ID, type, and associated data information.
 *
 * @since 2024-02-24
 */
public final class TableUnit {

    private final String id;
    private final TableType type;
    private final List<TableDataInfo> info = new ArrayList<>();

    /**
     * Constructs a new TableUnit with the specified ID, type, and data information.
     *
     * @param id   the ID of the table unit
     * @param type the type of the table unit
     * @param info the data information associated with the table unit
     */
    public TableUnit(@NotNull String id, @NotNull TableType type, @NotNull TableDataInfo... info) {
        this.id = id;
        this.type = type;
        this.info.addAll(List.of(info));
    }

    /**
     * Returns a string representation of the TableUnit object.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        ArrayList<String> command = new ArrayList<>(List.of(this.id, this.type.name()));

        this.info.forEach(info -> command.add(info.toString()));

        return String.join(" ", command);
    }

}

