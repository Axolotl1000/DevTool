package me.axolotl.api.tool;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger類別提供不同日誌等級的日誌功能。
 *
 * @since 2024-02-08
 */
public final class Logger {

    @Nullable
    private final String prefix;

    /**
     * 使用無前綴構造一個Logger。
     */
    public Logger() {
        this.prefix = null;
    }

    /**
     * 使用指定前綴構造一個Logger。
     *
     * @param prefix 要添加到日誌消息前面的前綴。
     */
    public Logger(@Nullable String prefix) {
        this.prefix = prefix == null ? null : String.format("[%s] ", prefix);
    }

    /**
     * 記錄一條信息消息。
     *
     * @param message 要記錄的消息。
     */
    public void info(@NotNull String message) {
        log("INFO", message);
    }

    /**
     * 記錄一條格式化的信息消息。
     *
     * @param message 格式化字符串。
     * @param args    格式字符串中格式化符號所引用的參數。
     */
    public void info(@NotNull String message, @NotNull Object... args) {
        log("INFO", message, args);
    }

    /**
     * 記錄一條警告消息。
     *
     * @param message 要記錄的消息。
     */
    public void warning(@NotNull String message) {
        log("WARNING", message);
    }

    /**
     * 記錄一條格式化的警告消息。
     *
     * @param message 格式化字符串。
     * @param args    格式字符串中格式化符號所引用的參數。
     */
    public void warning(@NotNull String message, @NotNull Object... args) {
        log("WARNING", message, args);
    }

    /**
     * 記錄一條嚴重消息。
     *
     * @param message 要記錄的消息。
     */
    public void severe(@NotNull String message) {
        log("SEVERE", message);
    }

    /**
     * 記錄一條格式化的嚴重消息。
     *
     * @param message 格式化字符串。
     * @param args    格式字符串中格式化符號所引用的參數。
     */
    public void severe(@NotNull String message, @NotNull Object... args) {
        log("SEVERE", message, args);
    }

    /**
     * 記錄一個嚴重消息和異常。
     *
     * @param exception 要記錄的異常。
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
