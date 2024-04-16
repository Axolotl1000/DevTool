package me.axolotl.api.tool;

import me.axolotl.api.exception.ChecksNotPassException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The Checks class provides utility methods for performing various checks on objects.
 *
 * @since 2024-02-18
 */
public final class Checks {

    /**
     * Ensures that the specified object is not null.
     *
     * @param o    the object to check for nullity
     * @param name the name of the object being checked
     * @throws ChecksNotPassException if the object is null
     */
    @Contract(value = "null, _ -> fail", pure = true)
    public static void NotNull(@Nullable Object o, @NotNull String name) throws ChecksNotPassException {
        if (o == null) {
            throw new ChecksNotPassException(name + " may not be empty.");
        }
    }

    /**
     * Ensures that the specified object is null.
     *
     * @param o    the object to check for nullity
     * @param name the name of the object being checked
     * @throws ChecksNotPassException if the object is not null
     */
    @Contract(value = "!null, _ -> fail", pure = true)
    public static void IsNull(@Nullable Object o, @NotNull String name) throws ChecksNotPassException {
        if (o != null) {
            throw new ChecksNotPassException(name + " may be empty.");
        }
    }

    /**
     * Ensures that all objects in the specified array extend the specified class.
     *
     * @param clazz the class to check against
     * @param os    the array of objects to check
     * @throws ChecksNotPassException if any object in the array does not extend the specified class
     */
    @Contract(pure = true)
    public static void AllExtends(@NotNull Class<?> clazz, Object @NotNull ... os) {
        for (Object o : os) {
            if (!clazz.isInstance(o)) {
                throw new ChecksNotPassException(o.getClass().getName() + " is not extend " + clazz.getName());
            }
        }
    }

}

