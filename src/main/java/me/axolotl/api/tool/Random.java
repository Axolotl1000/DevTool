package me.axolotl.api.tool;

/**
 * Random類別提供了生成隨機數的方法。
 *
 * @since 2024-03-04
 */
public final class Random {

    private static final java.util.Random randomNumberGenerator = new java.util.Random();

    /**
     * 生成一個隨機整數。
     *
     * @return 一個隨機整數
     */
    public static int randomAsInt() {
        return randomNumberGenerator.nextInt();
    }

    /**
     * 生成一個隨機長整數。
     *
     * @return 一個隨機長整數
     */
    public static long randomAsLong() {
        return randomNumberGenerator.nextLong();
    }

    /**
     * 生成一個隨機雙精度浮點數值。
     *
     * @return 一個隨機雙精度浮點數值
     */
    public static double randomAsDouble() {
        return randomNumberGenerator.nextDouble();
    }

    /**
     * 生成一個隨機單精度浮點數值。
     *
     * @return 一個隨機單精度浮點數值
     */
    public static float randomAsFloat() {
        return randomNumberGenerator.nextFloat();
    }

    /**
     * 生成指定範圍內的隨機整數。
     *
     * @param min 範圍的最小值（包括）
     * @param max 範圍的最大值（包括）
     * @return 指定範圍內的隨機整數
     */
    public static int between(int min, int max) {
        return randomNumberGenerator.nextInt(max - min + 1) + min;
    }
}
