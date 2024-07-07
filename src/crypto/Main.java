package crypto;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet();
        CaesarCipher cipher = new CaesarCipher(alphabet);

        String in = "C:\\Users\\panfi\\IdeaProjects\\CryptoAnalizer\\input.txt";
        String encrypted = "C:\\Users\\panfi\\IdeaProjects\\CryptoAnalizer\\encrypted.txt";
        String decrypted = "C:\\\\Users\\\\panfi\\\\IdeaProjects\\\\CryptoAnalizer\\\\decrypted.txt";
        int key = 3;

        Validator.isValidKey(key, alphabet);
        Validator.isFileExists(in);
        //Validator.isFileExists(encrypted);

        try {
            cipher.encrypt(in, encrypted, key);
            cipher.decrypt(encrypted, decrypted, key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
