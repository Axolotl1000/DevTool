package me.axolotl.api.tool;

import me.axolotl.api.interfaces.Serialization;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Map;

/**
 * Counter 允許創建一個簡單的計數器。
 *
 * @since 2024-02-08
 */
public final class Counter implements Serializable, Serialization<Counter> {

    /**
     * 常數，計數器能夠存儲的最大值為 2<sup>31</sup>-1。
     */
    public static final int MAX_VALUE = Integer.MAX_VALUE;

    /**
     * 常數，計數器能夠存儲的最小值為 -2<sup>31</sup>。
     */
    public static final int MIN_VALUE = Integer.MIN_VALUE;

    private int count;
    private final boolean aAble;
    private final boolean rmAble;

    Counter(int df, boolean aAble, boolean rmAble) {
        this.count = df;
        this.aAble = aAble;
        this.rmAble = rmAble;
    }

    /**
     * 增加計數器的數量。
     *
     * @param count 要添加的數量。
     * @return {@link Boolean} 執行是否成功。
     */
    public boolean add(int count) {
        if (this.aAble) {
            this.count = this.count + count;
            return true;
        }
        return false;
    }

    /**
     * 減少計數器的數量。
     *
     * @param count 要減去的數量。
     * @return {@link Boolean} 執行是否成功。
     */
    public boolean remove(int count) {
        if (this.rmAble) {
            this.count = this.count - count;
            return true;
        }
        return false;
    }

    /**
     * 獲取計數器的值。
     *
     * @return 當前值。
     */
    public int get() {
        return this.count;
    }

    @Override
    @NotNull
    public Map<String, Object> serialization() {
        return Map.of("now", this.count, "a", this.aAble ? "1" : "0", "r", this.rmAble ? "1" : "0");
    }

    @Override
    @NotNull
    public Counter unSerialization(Map<String, Object> serializedData) {
        return new Counter(((int) serializedData.get("now")), ((boolean) serializedData.get("a")), ((boolean) serializedData.get("r")));
    }

    // STATIC

    /**
     * 創建一個基本的計數器。
     *
     * @return {@link Counter} 新計數器。
     */
    public static Counter createDefault() {
        return new Counter(0, true, true);
    }

    /**
     * 創建一個具有預設值的基本計數器。
     *
     * @param defaultValue 設置默認值。
     * @return {@link Counter} 新計數器。
     */
    public static Counter createDefault(int defaultValue) {
        return new Counter(defaultValue, true, true);
    }

    /**
     * 創建一個只能增加的計數器。
     *
     * @return {@link Counter} 新計數器。
     */
    public static Counter createOnlyAdd() {
        return new Counter(0, true, false);
    }

    /**
     * 創建一個只能增加的具有預設值的計數器。
     *
     * @param defaultValue 設置默認值。
     * @return {@link Counter} 新計數器。
     */
    public static Counter createOnlyAdd(int defaultValue) {
        return new Counter(defaultValue, true, false);
    }

    /**
     * 創建一個只能減少的計數器。
     *
     * @return {@link Counter} 新計數器。
     */
    public static Counter createOnlyRemove() {
        return new Counter(0, false, true);
    }

    /**
     * 創建一個只能減少的具有預設值的計數器。
     *
     * @param defaultValue 設置默認值。
     * @return {@link Counter} 新計數器。
     */
    public static Counter createOnlyRemove(int defaultValue) {
        return new Counter(defaultValue, false, true);
    }
}
