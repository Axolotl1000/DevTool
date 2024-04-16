package me.axolotl.api.sql.excetption;

/**
 * The NonInConnectedException class represents an exception that is thrown when an operation is attempted on a
 * database connection that is not currently established.
 *
 * @since 2024-02-22
 */
public final class NonInConnectedException extends Exception {

    /**
     * Constructs a new NonInConnectedException with no detail message.
     */
    public NonInConnectedException() {
        super();
    }

    /**
     * Constructs a new NonInConnectedException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public NonInConnectedException(String message) {
        super(message);
    }

    /**
     * Constructs a new NonInConnectedException with the specified cause.
     *
     * @param cause the cause (which is saved for later retrieval by the getCause() method)
     */
    public NonInConnectedException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new NonInConnectedException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     * @param cause   the cause (which is saved for later retrieval by the getCause() method)
     */
    public NonInConnectedException(String message, Throwable cause) {
        super(message, cause);
    }
}

