package crypto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alphabet {
    private static final List<Character> ALPHABET = Arrays.asList('А', 'Б',
            'В','Г', 'Д', 'Е','Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У',
            'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э','Ю', 'Я');

    private static final List<Character> SPECIAL_CHARS_ALPHABET = Arrays.asList(
            '.', ',', '«', '»', ':', '!', '?', ' '
    );
    private final Map<Character, Integer> ALPHABET_KEYS = new HashMap<>();
    private final Map<Character, Integer> SPECIAL_CHARS_ALPHABET_KEYS = new HashMap<>();

    public Alphabet() {
        for (int i = 0; i < ALPHABET.size(); i++) {
            ALPHABET_KEYS.put(ALPHABET.get(i), i);
        }
        for (int i = 0; i < SPECIAL_CHARS_ALPHABET.size(); i++) {
            SPECIAL_CHARS_ALPHABET_KEYS.put(SPECIAL_CHARS_ALPHABET.get(i), i);
        }
    }

    public int getMaxKey() {
        return ALPHABET.size();
    }

    public int getSpecialCharMaxKey() {
        return SPECIAL_CHARS_ALPHABET.size();
    }

    public int getIndexByChar(char symbol) {
        return ALPHABET_KEYS.get(symbol);
    }

    public char getCharByIndex(int index) {
        return ALPHABET.get(index);
    }

    public int getIndexBySpecialChar(char symbol) {
        return SPECIAL_CHARS_ALPHABET_KEYS.get(symbol);
    }

    public char getSpecialCharByIndex(int index) {
        return SPECIAL_CHARS_ALPHABET.get(index);
    }
}
