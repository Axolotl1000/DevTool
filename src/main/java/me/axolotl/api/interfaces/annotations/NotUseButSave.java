package me.axolotl.api.interfaces.annotations;

import java.lang.annotation.*;

/**
 * The NotUseButSave annotation is used to mark methods, fields, or types that are not intended for immediate use
 * but are kept for future reference or potential future use.
 *
 * @since 2024-02-18
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface NotUseButSave {

    /**
     * Specifies the version or release in which the annotated element was introduced.
     *
     * @return the version or release in which the annotated element was introduced
     */
    String since() default "";

}
