package me.axolotl.api.sql.enumerate;

import me.axolotl.api.exception.MethodNotAllowed;
import org.jetbrains.annotations.NotNull;

/**
 * The TableDataInfo enum represents additional information for database table columns.
 *
 * @since 2024-02-24
 */
public enum TableDataInfo {

    /**
     * Represents the default value for a column.
     */
    DEFAULT,

    /**
     * Represents the length of a column.
     */
    LENGTH,

    /**
     * Represents whether a column is nullable.
     */
    NULLABLE,

    /**
     * Represents whether a column uses ZEROFILL.
     */
    ZEROFILL,

    /**
     * Represents whether a column is unsigned.
     */
    UNSIGNED,

    /**
     * Represents the comment associated with a column.
     */
    COMMENT;

    /* ========== ========== ========== ========== ========== */

    // Methods for ENUM DEFAULT

    @NotNull
    private String defValue = "";

    /**
     * Sets the default value for the column.
     *
     * @param s the default value to set
     * @return the TableDataInfo object with the updated default value
     * @throws MethodNotAllowed if called for an enum other than DEFAULT
     */
    public TableDataInfo setDefaultValue(@NotNull String s) {
        if (this != DEFAULT) throw new MethodNotAllowed("Only DEFAULT can use this method.");
        this.defValue = s;

        return this;
    }

    /**
     * Gets the default value of the column.
     *
     * @return the default value of the column
     * @throws MethodNotAllowed if called for an enum other than DEFAULT
     */
    public String getDefaultValue() {
        if (this != DEFAULT) throw new MethodNotAllowed("Only DEFAULT can use this method.");
        return defValue;
    }

    // Methods for ENUM LENGTH

    private int length = 0;

    /**
     * Sets the length of the column.
     *
     * @param length the length to set
     * @return the TableDataInfo object with the updated length
     * @throws MethodNotAllowed if called for an enum other than LENGTH
     */
    public TableDataInfo setLength(int length) {
        if (this != LENGTH) throw new MethodNotAllowed("Only LENGTH can use this method.");
        this.length = length;

        return this;
    }

    /**
     * Gets the length of the column.
     *
     * @return the length of the column
     * @throws MethodNotAllowed if called for an enum other than LENGTH
     */
    public int getLength() {
        if (this != LENGTH) throw new MethodNotAllowed("Only LENGTH can use this method.");
        return this.length;
    }

    // Methods for ENUM COMMENT

    private String comment = "";

    /**
     * Sets the comment for the column.
     *
     * @param comment the comment to set
     * @return the TableDataInfo object with the updated comment
     * @throws MethodNotAllowed if called for an enum other than COMMENT
     */
    public TableDataInfo setComment(String comment) {
        if (this != COMMENT) throw new MethodNotAllowed("Only COMMENT can use this method.");
        this.comment = comment;

        return this;
    }

    /**
     * Gets the comment for the column.
     *
     * @return the comment for the column
     * @throws MethodNotAllowed if called for an enum other than COMMENT
     */
    public String getComment() {
        if (this != COMMENT) throw new MethodNotAllowed("Only COMMENT can use this method.");
        return comment;
    }

    /* ========== ========== ========== ========== ========== */

    /**
     * Returns a string representation of the TableDataInfo object.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        switch (this) {
            case DEFAULT:
                return String.format("DEFAULT %s", getDefaultValue());
            case LENGTH:
                return String.format("(%s)", getLength());
            case NULLABLE:
                return "NULL";
            case COMMENT:
                return String.format("COMMENT '%s'", getComment());
            default:
                return this.name();
        }
    }

}
