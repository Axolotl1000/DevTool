package me.axolotl.api.tool;

import me.axolotl.api.exception.MethodNotAllowed;

/**
 * LambdaValue類別代表一個可變動或凍結的值。
 *
 * @param <T> 值的類型。
 * @since 2024-02-08
 */
public final class LambdaValue<T> {

    private T data;
    private final boolean nullable;
    private boolean changeable = true;

    /**
     * 使用可為空值構造一個新的LambdaValue。
     */
    public LambdaValue() {
        this.data = null;
        this.nullable = true;
    }

    /**
     * 使用指定值和可為空標誌構造一個新的LambdaValue。
     *
     * @param value 初始值。
     */
    public LambdaValue(T value) {
        this.data = value;
        this.nullable = true;
    }

    /**
     * 使用指定值和可為空標誌構造一個新的LambdaValue。
     *
     * @param value    初始值。
     * @param nullable 值是否可以為空。
     */
    public LambdaValue(T value, boolean nullable) {
        this.data = value;
        this.nullable = nullable;
    }

    /**
     * 凍結LambdaValue，使其無法更改。
     */
    public void freeze() {
        this.changeable = false;
    }

    /**
     * 設置LambdaValue的值。
     *
     * @param data 新的值。
     * @throws IllegalArgumentException 如果不允許null還是傳入null。
     * @throws MethodNotAllowed     如果LambdaValue已被凍結。
     */
    public void set(T data) {
        if (!this.nullable && data == null) {
            throw new IllegalArgumentException("Null not allowed");
        }
        if (!this.changeable) {
            throw new MethodNotAllowed(new IllegalAccessException("Changing Value not allowed"));
        }
        this.data = data;
    }

    /**
     * 獲取LambdaValue的值。
     *
     * @return 當前值。
     */
    public T get() {
        return data;
    }
}
