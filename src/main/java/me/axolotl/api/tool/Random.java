package me.axolotl.api.tool;

/**
 * The Random class provides methods for generating random numbers.
 *
 * @since 2024-03-04
 */
public class Random {

    private static final java.util.Random randomNumberGenerator = new java.util.Random();

    /**
     * Generates a random integer.
     *
     * @return a random integer
     */
    public static int randomAsInt() {
        return randomNumberGenerator.nextInt();
    }

    /**
     * Generates a random long integer.
     *
     * @return a random long integer
     */
    public static long randomAsLong() {
        return randomNumberGenerator.nextLong();
    }

    /**
     * Generates a random double value.
     *
     * @return a random double value
     */
    public static double randomAsDouble() {
        return randomNumberGenerator.nextDouble();
    }

    /**
     * Generates a random float value.
     *
     * @return a random float value
     */
    public static float randomAsFloat() {
        return randomNumberGenerator.nextFloat();
    }

    /**
     * Generates a random integer within the specified range.
     *
     * @param min the minimum value (inclusive) of the range
     * @param max the maximum value (inclusive) of the range
     * @return a random integer within the specified range
     */
    public static int between(int min, int max) {
        return randomNumberGenerator.nextInt(max - min + 1) + min;
    }
}

