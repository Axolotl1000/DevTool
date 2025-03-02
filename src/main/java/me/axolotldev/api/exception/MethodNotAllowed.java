package me.axolotldev.api.exception;

/**
 * MethodNotAllowed異常在試圖調用不允許的方法時拋出。
 *
 * @since 2024-02-08
 */
public final class MethodNotAllowed extends RuntimeException {

    /**
     * 構造一個新的MethodNotAllowed異常，沒有詳細消息。
     */
    public MethodNotAllowed() {
        super();
    }

    /**
     * 構造一個新的MethodNotAllowed異常，帶有指定的詳細消息。
     *
     * @param message 詳細消息。
     */
    public MethodNotAllowed(String message) {
        super(message);
    }

    /**
     * 構造一個新的MethodNotAllowed異常，帶有指定的原因。
     *
     * @param cause 異常的原因。
     */
    public MethodNotAllowed(Throwable cause) {
        super(cause);
    }

    /**
     * 構造一個新的MethodNotAllowed異常，帶有指定的詳細消息和原因。
     *
     * @param message 詳細消息。
     * @param cause   異常的原因。
     */
    public MethodNotAllowed(String message, Throwable cause) {
        super(message, cause);
    }
}
