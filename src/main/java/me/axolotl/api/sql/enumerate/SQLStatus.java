package me.axolotl.api.sql.enumerate;

/**
 * SQLStatus枚舉表示SQL連接狀態的各種狀態。
 *
 * @since 2024-02-22
 */
public enum SQLStatus {

    /**
     * 未知的SQL狀態。
     */
    UNKNOWN(-1),

    /**
     * 目前正在連接到SQL。
     */
    CONNECTING(0),

    /**
     * SQL連接已建立。
     */
    CONNECTED(1),

    /**
     * SQL連接正在處理中。
     */
    PROCESSING(2),

    /**
     * 目前正在從SQL斷開連接。
     */
    DISCONNECTING(3),

    /**
     * SQL連接已斷開。
     */
    DISCONNECTED(4),

    /**
     * SQL連接中發生錯誤。
     */
    ERROR(5);

    private final int level;

    /**
     * 使用指定的級別構造一個新的SQLStatus。
     *
     * @param level 表示狀態的級別
     */
    SQLStatus(int level) {
        this.level = level;
    }

    /**
     * 根據指定的級別獲取與之對應的SQLStatus枚舉常量。
     *
     * @param level 表示狀態的級別
     * @return 與指定級別相關聯的SQLStatus枚舉常量，如果找不到匹配項則返回UNKNOWN
     */
    public static SQLStatus getByLevel(int level) {
        for (SQLStatus ss : values()) {
            if (ss.level == level) {
                return ss;
            }
        }
        return UNKNOWN;
    }
}
