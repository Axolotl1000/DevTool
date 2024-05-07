package me.axolotl.api.sql.excetption;

/**
 * NonInConnectedException異常在使用未連接的對象時拋出。
 *
 * @since 2024-02-22
 */
public final class NonInConnectedException extends Exception {
    /**
     * 構造一個新的NonInConnectedException異常，沒有詳細消息。
     */
    public NonInConnectedException() {
        super();
    }

    /**
     * 構造一個新的NonInConnectedException異常，帶有指定的詳細消息。
     *
     * @param message 詳細消息。
     */
    public NonInConnectedException(String message) {
        super(message);
    }

    /**
     * 構造一個新的NonInConnectedException異常，帶有指定的原因。
     *
     * @param cause 異常的原因。
     */
    public NonInConnectedException(Throwable cause) {
        super(cause);
    }

    /**
     * 構造一個新的NonInConnectedException異常，帶有指定的詳細消息和原因。
     *
     * @param message 詳細消息。
     * @param cause   異常的原因。
     */
    public NonInConnectedException(String message, Throwable cause) {
        super(message, cause);
    }
}
