package me.axolotl.api.tool;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * The FileReader class provides utility methods for reading from and saving to files.
 *
 * @since 2024-02-08
 */
public final class FileReader {

    /**
     * Reads the contents of a file into a collection of strings.
     *
     * @param file The file to read.
     * @return A collection containing the lines read from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static @NotNull Collection<String> read(File file) throws IOException {
        Collection<String> output = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.add(line);
            }
        }

        return output;
    }

    /**
     * Saves the specified data to a file.
     *
     * @param file The file to save the data to.
     * @param data The data to save.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void save(File file, String @NotNull ... data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String s : data) {
                writer.write(s);
                writer.newLine();
            }
        }
    }

    /**
     * Writes the specified data below the existing content of a file.
     *
     * @param file The file to write the data to.
     * @param data The data to write.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void writeBelow(File file, @NotNull String data) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file, true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        }
    }
}

