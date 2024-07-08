package crypto;

import java.io.File;

public class Validator {
    public static void isValidKey(int key, Alphabet alphabet) {// Проверка ключа
        if (key <= -alphabet.getMaxKey() || key >= alphabet.getMaxKey() || key == 0) {
            throw new IllegalArgumentException("key '" + key + "' is invalid");
        }
    }

    public static void isFileExists(File file) {// Проверка существования файла
        if (!file.exists()) {
            throw new IllegalArgumentException("file '" + file.getAbsolutePath() + "' do not exist");
        }
    }
}

