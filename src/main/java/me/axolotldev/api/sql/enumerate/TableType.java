package me.axolotldev.api.sql.enumerate;

/**
 * TableType枚舉表示數據庫表列的數據類型。
 *
 * @since 2024-02-24
 */
public enum TableType {
    /**
     * 字符類型。
     */
    CHAR,

    /**
     * 變長字符類型。
     */
    VARCHAR,

    /**
     * 文本類型。
     */
    TEXT,

    /**
     * 整數類型。
     */
    INT,

    /**
     * 大整數類型。
     */
    BIGINT,

    /**
     * 十進制類型。
     */
    DECIMAL,

    /**
     * 日期類型。
     */
    DATE,

    /**
     * 時間類型。
     */
    TIME,

    /**
     * 時間戳類型。
     */
    TIMESTAMP,

    /**
     * 二進制類型。
     */
    BINARY,

    /**
     * 變長二進制類型。
     */
    VARBINARY,

    /**
     * 二進制大對象類型。
     */
    BLOB,

    /**
     * 布林類型。
     */
    BOOLEAN
}
