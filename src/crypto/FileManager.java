package crypto;

import java.io.*;
import java.util.function.Function;

public class FileManager {

    public void processFile(
            File inputFile,
            File outputFile,
            Function<Character, Character> charProcessor
    ) {
        try (FileReader in = new FileReader(inputFile);
             FileWriter writer = new FileWriter(outputFile)) {
            char[] buffer = new char[65536];
            while (in.ready()) {
                int real = in.read(buffer);
                for (int i = 0; i < real; i++) {
                    buffer[i] = charProcessor.apply(buffer[i]);
                }
                writer.write(buffer, 0, real);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

