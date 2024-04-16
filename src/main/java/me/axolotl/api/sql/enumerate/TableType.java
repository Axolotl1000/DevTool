package me.axolotl.api.sql.enumerate;

/**
 * The TableType enum represents data types for database table columns.
 *
 * @since 2024-02-24
 */
public enum TableType {
    /**
     * Character type.
     */
    CHAR,

    /**
     * Variable-length character type.
     */
    VARCHAR,

    /**
     * Text type.
     */
    TEXT,

    /**
     * Integer type.
     */
    INT,

    /**
     * Big integer type.
     */
    BIGINT,

    /**
     * Decimal type.
     */
    DECIMAL,

    /**
     * Date type.
     */
    DATE,

    /**
     * Time type.
     */
    TIME,

    /**
     * Timestamp type.
     */
    TIMESTAMP,

    /**
     * Binary type.
     */
    BINARY,

    /**
     * Variable-length binary type.
     */
    VARBINARY,

    /**
     * Binary large object type.
     */
    BLOB,

    /**
     * Boolean type.
     */
    BOOLEAN
}

