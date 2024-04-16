package me.axolotl.api.sql.enumerate;

/**
 * The SQLStatus enum represents various states of SQL connection status.
 *
 * @since 2024-02-22
 */
public enum SQLStatus {

    /**
     * Unknown SQL status.
     */
    UNKNOWN(-1),

    /**
     * Currently connecting to SQL.
     */
    CONNECTING(0),

    /**
     * SQL connection established.
     */
    CONNECTED(1),

    /**
     * SQL connection is processing.
     */
    PROCESSING(2),

    /**
     * Currently disconnecting from SQL.
     */
    DISCONNECTING(3),

    /**
     * SQL connection disconnected.
     */
    DISCONNECTED(4),

    /**
     * Error occurred in SQL connection.
     */
    ERROR(5);

    private final int level;

    /**
     * Constructs a new SQLStatus with the specified level.
     *
     * @param level the level representing the status
     */
    SQLStatus(int level) {
        this.level = level;
    }

    /**
     * Gets the SQLStatus enum constant associated with the specified level.
     *
     * @param level the level representing the status
     * @return the SQLStatus enum constant associated with the specified level, or UNKNOWN if no match is found
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
