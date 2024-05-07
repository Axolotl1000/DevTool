package me.axolotl.api.tool;

import me.axolotl.api.exception.ChecksNotPassException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Checks類別提供了執行對象的各種檢查的實用方法。
 *
 * @since 2024-02-18
 */
public final class Checks {

    /**
     * 確保指定的對象不為null。
     *
     * @param o    要檢查null性的對象
     * @param name 正在檢查的對象的名稱
     * @throws ChecksNotPassException 如果對象為null
     */
    @Contract(value = "null, _ -> fail", pure = true)
    public static void NotNull(@Nullable Object o, @NotNull String name) throws ChecksNotPassException {
        if (o == null) {
            throw new ChecksNotPassException(name + " may not be empty.");
        }
    }

    /**
     * 確保指定的對象為null。
     *
     * @param o    要檢查null性的對象
     * @param name 正在檢查的對象的名稱
     * @throws ChecksNotPassException 如果對象不為null
     */
    @Contract(value = "!null, _ -> fail", pure = true)
    public static void IsNull(@Nullable Object o, @NotNull String name) throws ChecksNotPassException {
        if (o != null) {
            throw new ChecksNotPassException(name + " may be empty.");
        }
    }

    /**
     * 確保指定陣列中的所有對象都擴展了指定的類。
     *
     * @param clazz 要檢查的類
     * @param os    要檢查的對象陣列
     * @throws ChecksNotPassException 如果陣列中的任何對象未擴展指定的類
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
