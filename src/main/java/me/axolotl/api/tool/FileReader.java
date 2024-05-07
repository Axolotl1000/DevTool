package me.axolotl.api.tool;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * FileReader類別提供了用於從文件讀取和保存數據的實用方法。
 *
 * @since 2024-02-08
 */
public final class FileReader {

    /**
     * 將文件的內容讀取到一個字符串集合中。
     *
     * @param file 要讀取的文件。
     * @return 包含從文件讀取的行的集合。
     * @throws IOException 如果在讀取文件時發生I/O錯誤。
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
     * 將指定的數據保存到文件中。
     *
     * @param file 要保存數據的文件。
     * @param data 要保存的數據。
     * @throws IOException 如果在寫入文件時發生I/O錯誤。
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
     * 將指定的數據寫入文件現有內容的下方。
     *
     * @param file 要將數據寫入的文件。
     * @param data 要寫入的數據。
     * @throws IOException 如果在寫入文件時發生I/O錯誤。
     */
    public static void writeBelow(File file, @NotNull String data) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file, true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        }
    }
}
