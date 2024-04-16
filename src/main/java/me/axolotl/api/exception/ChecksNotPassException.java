package me.axolotl.api.exception;

/**
 * The ChecksNotPassException class represents an exception thrown when checks fail.
 *
 * @since 2024-02-18
 */
public final class ChecksNotPassException extends RuntimeException {

    /**
     * Constructs a new ChecksNotPassException with no detail message.
     */
    public ChecksNotPassException() {
        super();
    }

    /**
     * Constructs a new ChecksNotPassException with the specified detail message.
     *
     * @param message the detail message
     */
    public ChecksNotPassException(String message) {
        super(message);
    }

    /**
     * Constructs a new ChecksNotPassException with the specified cause.
     *
     * @param cause the cause
     */
    public ChecksNotPassException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new ChecksNotPassException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause   the cause
     */
    public ChecksNotPassException(String message, Throwable cause) {
        super(message, cause);
    }
}

