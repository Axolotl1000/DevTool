package me.axolotl.api.tool;

import me.axolotl.api.exception.MethodNotAllowed;

import java.util.function.Consumer;

/**
 * The ExceptionHandler class provides utility methods for handling exceptions.
 *
 * @since 2024-02-08
 */
public final class ExceptionHandler {

    /**
     * Enum representing different levels of exceptions.
     */
    public enum ExceptionLevel {
        EXCEPTION, ERROR
    }

    /**
     * Executes the specified function and handles any exceptions using the provided error handler.
     *
     * @param function     The function to execute.
     * @param errorHandler The consumer to handle exceptions.
     * @deprecated
     */
    @Deprecated(since = "2024-02-13")
    public static void handleException(Runnable function, Consumer<Throwable> errorHandler) {
        throw new MethodNotAllowed("This Method is Deprecated.");
    }

    /**
     * Determines the level of an exception.
     *
     * @param throwable The throwable to analyze.
     * @return The exception level.
     */
    public static ExceptionLevel ExceptionLevel(Throwable throwable) {
        return (throwable instanceof Error) ? ExceptionLevel.ERROR : ExceptionLevel.EXCEPTION;
    }
}


