package me.axolotl.api.tool;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Logger class provides logging functionality with different log levels.
 *
 * @since 2024-02-08
 */
public final class Logger {

    @Nullable
    private final String prefix;

    /**
     * Constructs a Logger with no prefix.
     */
    public Logger() {
        this.prefix = null;
    }

    /**
     * Constructs a Logger with the specified prefix.
     *
     * @param prefix The prefix to prepend to log messages.
     */
    public Logger(@Nullable String prefix) {
        this.prefix = prefix == null ? null : String.format("[%s] ", prefix);
    }

    /**
     * Logs an informational message.
     *
     * @param message The message to log.
     */
    public void info(@NotNull String message) {
        log("INFO", message);
    }

    /**
     * Logs a formatted informational message.
     *
     * @param message The format string.
     * @param args    The arguments referenced by the format specifiers in the format string.
     */
    public void info(@NotNull String message, @NotNull Object... args) {
        log("INFO", message, args);
    }

    /**
     * Logs a warning message.
     *
     * @param message The message to log.
     */
    public void warning(@NotNull String message) {
        log("WARNING", message);
    }

    /**
     * Logs a formatted warning message.
     *
     * @param message The format string.
     * @param args    The arguments referenced by the format specifiers in the format string.
     */
    public void warning(@NotNull String message, @NotNull Object... args) {
        log("WARNING", message, args);
    }

    /**
     * Logs a severe message.
     *
     * @param message The message to log.
     */
    public void severe(@NotNull String message) {
        log("SEVERE", message);
    }

    /**
     * Logs a formatted severe message.
     *
     * @param message The format string.
     * @param args    The arguments referenced by the format specifiers in the format string.
     */
    public void severe(@NotNull String message, @NotNull Object... args) {
        log("SEVERE", message, args);
    }

    /**
     * Logs a severe message along with an exception.
     *
     * @param exception The exception to log.
     */
    public void severe(@NotNull Exception exception) {
        logException(exception);
    }

    private void log(@NotNull String level, @NotNull String message) {
        for (String s : message.split("\n")) {
            System.out.printf("%s[%s] [%s] %s\n", prefix, level, getTime(), s);
        }
    }

    private void log(@NotNull String level, @NotNull String message, @NotNull Object... args) {
        message = String.format(message, args);
        for (String s : message.split("\n")) {
            System.out.printf("%s[%s] [%s] %s\n", prefix, level, getTime(), s);
        }
    }

    private void logException(@NotNull Exception exception) {
        System.err.printf("%s[SEVERE] [%s] Exception occurred: %s\n", prefix, getTime(), exception.getMessage());
        for (StackTraceElement element : exception.getStackTrace()) {
            System.err.printf("%s[SEVERE] [%s] %s\n", prefix, getTime(), element);
        }
    }

    @NotNull
    private String getTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentDateTime.format(formatter);
    }
}


