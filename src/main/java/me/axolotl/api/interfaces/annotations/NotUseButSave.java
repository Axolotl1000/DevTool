package me.axolotl.api.interfaces.annotations;

import java.lang.annotation.*;

/**
 * NotUseButSave註釋用於標記不打算立即使用的方法、字段或類型，
 * 但保留供將來參考或可能的將來使用。
 *
 * @since 2024-02-18
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface NotUseButSave {

    /**
     * 指定標註元素被引入的版本或發布版。
     *
     * @return 標註元素被引入的版本或發布版
     */
    String since() default "";

}
