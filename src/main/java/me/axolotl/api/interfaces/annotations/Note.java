package me.axolotl.api.interfaces.annotations;

import java.lang.annotation.Documented;

/**
 * The Note annotation is used to attach notes or messages to annotated elements.
 *
 * @since 2024-02-22
 * @deprecated in 2024-04-13
 */
@Documented
@Deprecated(since = "2024-04-13")
public @interface Note {

    /**
     * Specifies the message attached to the annotated element.
     *
     * @return the message attached to the annotated element
     */
    String messages() default "";

}

