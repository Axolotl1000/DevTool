package me.axolotl.api.exception;

/**
 * ChecksNotPassException類表示在檢查失敗時拋出的異常。
 *
 * @since 2024-02-18
 */
public final class ChecksNotPassException extends RuntimeException {

    /**
     * 構造一個新的ChecksNotPassException，沒有詳細消息。
     */
    public ChecksNotPassException() {
        super();
    }

    /**
     * 構造一個新的ChecksNotPassException，帶有指定的詳細消息。
     *
     * @param message 詳細消息
     */
    public ChecksNotPassException(String message) {
        super(message);
    }

    /**
     * 構造一個新的ChecksNotPassException，帶有指定的原因。
     *
     * @param cause 原因
     */
    public ChecksNotPassException(Throwable cause) {
        super(cause);
    }

    /**
     * 構造一個新的ChecksNotPassException，帶有指定的詳細消息和原因。
     *
     * @param message 詳細消息
     * @param cause   原因
     */
    public ChecksNotPassException(String message, Throwable cause) {
        super(message, cause);
    }
}
