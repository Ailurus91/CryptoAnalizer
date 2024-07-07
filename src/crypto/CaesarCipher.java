package crypto;

import java.io.*;

public class CaesarCipher {
    private final Alphabet alphabet;
    // Алфавит
//    private static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзиклмнопрстуфхцчшщъыьэя\\.:,«»!? ";
//    private static final int ALPHABET_LENGTH = ALPHABET.length() - 1;

    public CaesarCipher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    // Методы для шифрования расшифровки, brute force, статистического анализа

//    private char encrypt(char symbol, int key) {
//        boolean isLowerCase = Character.isLowerCase(symbol);
//        int index = ALPHABET.indexOf(Character.toUpperCase(symbol));
//        if (index != -1) {
//            int newIndex = index + key;
//            if (newIndex < 0) {
//                newIndex = ALPHABET_LENGTH + newIndex;
//            } else if (newIndex > ALPHABET_LENGTH) {
//                newIndex = newIndex - ALPHABET_LENGTH;
//            }
//            symbol = ALPHABET.charAt(newIndex);
////                        buffer[i] = ALPHABET.charAt(i + key);
//        }
//        if (isLowerCase) {
//            symbol = Character.toLowerCase(symbol);
//        }
//        return symbol;
//    }

    private char encrypt(char symbol, int key) {
        if (Character.isAlphabetic(symbol)) {
            return encryptRegularChar(symbol, key);
        } else {
            return encryptSpecialChar(symbol, key);
        }
    }

    private char encryptRegularChar(char symbol, int key) {
        boolean isLowerCase = Character.isLowerCase(symbol);
        int index = alphabet.getIndexByChar(Character.toUpperCase(symbol));
        if (index != -1) {
            int newIndex = index + key;
            if (newIndex < 0) {
                newIndex = alphabet.getMaxKey() + newIndex + 1;
            } else if (newIndex > alphabet.getMaxKey()) {
                newIndex = newIndex - alphabet.getMaxKey() - 1;
            }
            symbol = alphabet.getCharByIndex(newIndex);
        }
        if (isLowerCase) {
            symbol = Character.toLowerCase(symbol);
        }
        return symbol;
    }

    private char encryptSpecialChar(char symbol, int key) {
        int index = alphabet.getIndexBySpecialChar(symbol);
        if (index != -1) {
            int newIndex = index + key;
            if (newIndex < 0) {
                newIndex = alphabet.getSpecialCharMaxKey() + newIndex + 1;
            } else if (newIndex > alphabet.getSpecialCharMaxKey()) {
                newIndex = newIndex - alphabet.getSpecialCharMaxKey() - 1;
            }
            symbol = alphabet.getSpecialCharByIndex(newIndex);
        }
        return symbol;
    }

    // Реализация шифрования
    public void encrypt(String inputFile, String outputFile, int key) throws IOException {
        try (FileReader in = new FileReader(inputFile);
             FileWriter writer = new FileWriter(outputFile)) {
            char[] buffer = new char[65536];
            while (in.ready()) {
                int real = in.read(buffer);
                for (int i = 0; i < real; i++) {
                    buffer[i] = encrypt(buffer[i], key);
                }
                writer.write(buffer, 0, real);
            }
        }
    }

    // Реализация расшифровки
    public void decrypt(String inputFile, String outputFile, int key) throws IOException {
        encrypt(inputFile, outputFile, -key);
    }

    public void bruteForce(String inputFile, String outputFile,
                           String optionalSampleFile) {
        String[] popularWords  = new String[] {"И", "В", "НО", "К", "ЧЕЛОВЕК", "ГЛАЗ", "РАЗ", "СЛОВО","ДЕНЬ","РУКА","ЖИЗНЬ","ДЕЛО","ГОД","ВРЕМЯ", " "};

        int key;
//        for (key = -ALPHABET_LENGTH; key <= ALPHABET_LENGTH; key++) {
//
//
//        }// Реализация brute force
    }

    public void statisticalAnalysis(String inputFile,
                                    String outputFile, String optionalSampleFile) {
        // Реализация статистического анализа
    }

    // Вспомогательные методы: validateInput(), createAlphabet(), shiftCharacter(), readFile(), writeFile()

//    public static void main(String[] args) throws IOException {
//        CaesarCipher cipher = new CaesarCipher();
////        cipher.encrypt(
////                "C:\\Users\\panfi\\IdeaProjects\\CryptoAnalizer\\input.txt",
////                "C:\\Users\\panfi\\IdeaProjects\\CryptoAnalizer\\output.txt",
////                3
////        );
//        cipher.encrypt(
//                "C:\\Users\\panfi\\IdeaProjects\\CryptoAnalizer\\output.txt",
//                "C:\\Users\\panfi\\IdeaProjects\\CryptoAnalizer\\decrypted.txt",
//                -3
//        );
//        // Логика меню
//        // 1. Шифрование
//        // 2. Расшифровка с ключом
//        // 3. Brute force
//        // 4. Статистический анализ
//        // 0. Выход
//
//        // Пример вызова метода шифрования:
//        // cipher.encrypt("input.txt", "output.txt", 3);
//    }
}

