package crypto;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Validator {
    public static void isValidKey(int key, Alphabet alphabet) {// Проверка ключа
        if (key < -alphabet.getMaxKey() || key > alphabet.getMaxKey()) {
            throw new IllegalArgumentException("key '" + key + "' is invalid");
        }
    }

    public static void isFileExists(String filePath) {// Проверка существования файла
        Path file = Paths.get(filePath);
        if (!Files.exists(file)) {
            throw new IllegalArgumentException("file '" + filePath + "' do not exist");
        }
    }
}

