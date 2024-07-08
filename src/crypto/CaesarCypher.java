package crypto;

public class CaesarCypher {
    private final Alphabet alphabet;

    public CaesarCypher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    // Методы для шифрования расшифровки, brute force, статистического анализа

    public char encrypt(char symbol, int key) {
        if (Character.isAlphabetic(symbol)) {
            return encryptRegularChar(symbol, key);
        } else {
            return encryptSpecialChar(symbol, key);
        }
    }

    public char decrypt(char symbol, int key) {
        return encrypt(symbol, -key);
    }

    private char encryptRegularChar(char symbol, int key) {
        boolean isLowerCase = Character.isLowerCase(symbol);
        int index = alphabet.getIndexByChar(Character.toUpperCase(symbol));
        if (index != -1) {
            int newIndex = index + key;
            if (newIndex < 0) {
                newIndex = alphabet.getMaxKey() + newIndex;
            } else if (newIndex > alphabet.getMaxKey()) {
                newIndex = newIndex - alphabet.getMaxKey();
            } else if (newIndex == alphabet.getMaxKey()) {
                newIndex = 0;
            }
            symbol = alphabet.getCharByIndex(newIndex);
        }
        if (isLowerCase) {
            symbol = Character.toLowerCase(symbol);
        }
        return symbol;
    }

    private char encryptSpecialChar(char symbol, int key) {
        if (key >= alphabet.getSpecialCharMaxKey()) {
            key = key % alphabet.getSpecialCharMaxKey();
        }
        int index = alphabet.getIndexBySpecialChar(symbol);
        if (index != -1) {
            int newIndex = index + key;
            if (newIndex < 0) {
                while (newIndex < 0) {
                    newIndex = alphabet.getSpecialCharMaxKey() + newIndex;
                }
            } else if (newIndex > alphabet.getSpecialCharMaxKey()) {
                while (newIndex > alphabet.getSpecialCharMaxKey()) {
                    newIndex = newIndex - alphabet.getSpecialCharMaxKey();
                }
            } else if (newIndex == alphabet.getSpecialCharMaxKey()) {
                newIndex = 0;
            }
            symbol = alphabet.getSpecialCharByIndex(newIndex);
        }
        return symbol;
    }

//    public void bruteForce(String inputFile, String outputFile,
//                           String optionalSampleFile) {
//        String[] popularWords = new String[]{"И", "В", "НО", "К", "ЧЕЛОВЕК", "ГЛАЗ", "РАЗ", "СЛОВО", "ДЕНЬ", "РУКА", "ЖИЗНЬ", "ДЕЛО", "ГОД", "ВРЕМЯ", " "};
//
//        int key;
//        for (key = -ALPHABET_LENGTH; key <= ALPHABET_LENGTH; key++) {
//
//
//        }// Реализация brute force
    }



