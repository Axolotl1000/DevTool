package me.axolotl.api.exception;

/**
 * The MethodNotAllowed exception is thrown when an attempt is made to invoke a method that is not allowed.
 *
 * @since 2024-02-08
 */
public final class MethodNotAllowed extends RuntimeException {

    /**
     * Constructs a new MethodNotAllowed exception with no detail message.
     */
    public MethodNotAllowed() {
        super();
    }

    /**
     * Constructs a new MethodNotAllowed exception with the specified detail message.
     *
     * @param message The detail message.
     */
    public MethodNotAllowed(String message) {
        super(message);
    }

    /**
     * Constructs a new MethodNotAllowed exception with the specified cause.
     *
     * @param cause The cause of the exception.
     */
    public MethodNotAllowed(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new MethodNotAllowed exception with the specified detail message and cause.
     *
     * @param message The detail message.
     * @param cause   The cause of the exception.
     */
    public MethodNotAllowed(String message, Throwable cause) {
        super(message, cause);
    }
}

