package me.axolotl.api.tool;

import me.axolotl.api.interfaces.Serialization;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Map;

/**
 * Counter allows the creation of a simple counter
 *
 * @since 2024-02-08
 */

public final class Counter implements Serializable, Serialization<Counter> {

    /**
     * A constant, the maximum value that the counter can store
     * is 2<sup>31</sup>-1.
     */
    public static final int MAX_VALUE = Integer.MAX_VALUE;

    /**
     * A constant, the minimum value that the counter can store
     * is -2<sup>31</sup>.
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
     * Increase the counter number
     *
     * @param count The amount to be added
     * @return {@link Boolean} Whether the execution was successful
     */
    public boolean add(int count) {
        if (this.aAble) {
            this.count = this.count + count;
            return true;
        }
        return false;
    }

    /**
     * Decrease the counter number
     *
     * @param count The amount to be subtracted
     * @return {@link Boolean} Whether the execution was successful
     */

    public boolean remove(int count) {
        if (this.rmAble) {
            this.count = this.count - count;
            return true;
        }
        return false;
    }

    /**
     * Gets the value of the Counter.
     *
     * @return The current value.
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
     * Create a basic counter
     *
     * @return {@link Counter} New counter
     */
    public static Counter createDefault() {
        return new Counter(0, true, true);
    }

    /**
     * Create a basic counter with a default value
     *
     * @param defaultValue Set default value
     * @return {@link Counter} New counter
     */
    public static Counter createDefault(int defaultValue) {
        return new Counter(defaultValue, true, true);
    }

    /**
     * Create a counter that can only be added
     *
     * @return {@link Counter} New counter
     */
    public static Counter createOnlyAdd() {
        return new Counter(0, true, false);
    }


    /**
     * Create a counter that can only be added with a default value
     *
     * @param defaultValue Set default value
     * @return {@link Counter} New counter
     */
    public static Counter createOnlyAdd(int defaultValue) {
        return new Counter(defaultValue, true, false);
    }


    /**
     * Create a counter that can only be subtracted
     *
     * @return {@link Counter} New counter
     */
    public static Counter createOnlyRemove() {
        return new Counter(0, false, false);
    }


    /**
     * Create a counter that can only be subtracted with a default value
     *
     * @param defaultValue Set default value
     * @return {@link Counter} New counter
     */
    public static Counter createOnlyRemove(int defaultValue) {
        return new Counter(defaultValue, false, true);
    }
}
