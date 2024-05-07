package me.axolotl.api.tool;

import me.axolotl.api.exception.MethodNotAllowed;

import java.util.function.Consumer;

/**
 * ExceptionHandler類別提供了處理異常的實用方法。
 *
 * @since 2024-02-08
 */
public final class ExceptionHandler {

    /**
     * 表示不同級別異常的枚舉。
     */
    public enum ExceptionLevel {
        EXCEPTION, ERROR
    }

    /**
     * 執行指定的函數並使用提供的錯誤處理程序處理任何異常。
     *
     * @param function     要執行的函數。
     * @param errorHandler 用於處理異常的處理器。
     * @deprecated  自2024-02-13起
     */
    @Deprecated(since = "2024-02-13")
    public static void handleException(Runnable function, Consumer<Throwable> errorHandler) {
        throw new MethodNotAllowed("This Method is Deprecated.");
    }

    /**
     * 確定異常的級別。
     *
     * @param throwable 要分析的異常。
     * @return 異常級別。
     */
    public static ExceptionLevel ExceptionLevel(Throwable throwable) {
        return (throwable instanceof Error) ? ExceptionLevel.ERROR : ExceptionLevel.EXCEPTION;
    }
}
