package me.axolotl.api.tool;

import me.axolotl.api.exception.MethodNotAllowed;

/**
 * The LambdaValue class represents a value that can be changed or frozen.
 *
 * @param <T> The type of the value.
 * @since 2024-02-08
 */
public final class LambdaValue<T> {

    private T data;
    private final boolean nullable;
    private boolean changeable = true;

    /**
     * Constructs a new LambdaValue with a nullable value.
     */
    public LambdaValue() {
        this.data = null;
        this.nullable = true;
    }

    /**
     * Constructs a new LambdaValue with the specified value and nullable as true.
     *
     * @param value The initial value.
     */
    public LambdaValue(T value) {
        this.data = value;
        this.nullable = true;
    }

    /**
     * Constructs a new LambdaValue with the specified value and nullable flag.
     *
     * @param value    The initial value.
     * @param nullable Whether the value can be null or not.
     */
    public LambdaValue(T value, boolean nullable) {
        this.data = value;
        this.nullable = nullable;
    }

    /**
     * Freezes the LambdaValue, making it unchangeable.
     */
    public void freeze() {
        this.changeable = false;
    }

    /**
     * Sets the value of the LambdaValue.
     *
     * @param data The new value.
     * @throws NullPointerException If nullable is false and data is null.
     * @throws MethodNotAllowed     If the LambdaValue is frozen.
     */
    public void set(T data) {
        if (!this.nullable && data == null) {
            throw new NullPointerException("Null not allowed");
        }
        if (!this.changeable) {
            throw new MethodNotAllowed(new IllegalAccessException("Changing Value not allowed"));
        }
        this.data = data;
    }

    /**
     * Gets the value of the LambdaValue.
     *
     * @return The current value.
     */
    public T get() {
        return data;
    }
}

