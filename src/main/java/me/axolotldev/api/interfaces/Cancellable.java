package me.axolotldev.api.interfaces;

/**
 * Cancellable介面表示可以取消的實體。
 *
 * @since 2024-02-08
 */
public interface Cancellable {

    /**
     * 設置實體的取消狀態。
     *
     * @param canceled 如果想取消實體，則輸入true，否則輸入false。
     */
    void setCancel(boolean canceled);

    /**
     * 檢查實體是否被取消。
     *
     * @return 如果實體被取消則返回true，否則返回false。
     */
    boolean isCanceled();

}
