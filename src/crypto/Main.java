package crypto;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private static final Alphabet alphabet = new Alphabet();
    private static final CaesarCypher cipher = new CaesarCypher(alphabet);
    private static final FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - encrypt");
        System.out.println("2 - decrypt");
        System.out.println("3 - quit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                subMenu(false);
                break;
            case 2:
                subMenu(true);
                break;
            case 3:
                // Perform "quit" case.
                break;
            default:
                // The user input an unexpected choice.
        }
    }

    private static void subMenu(boolean decrypt) {
        String action = "encrypt";
        if (decrypt) {
            action = "decrypt";
        }
        Path currentRelativePath = Paths.get("");
        String defaultSrcFilePath = currentRelativePath
                .resolve("input.txt")
                .toAbsolutePath().toString();
        if (decrypt) {
            defaultSrcFilePath = currentRelativePath
                    .resolve("encrypted.txt")
                    .toAbsolutePath().toString();
        }
        System.out.println("Enter input file path: (leave empty for default '" + defaultSrcFilePath + "' path)");
        System.out.println("-------------------------\n");

        Scanner scanner = new Scanner(System.in);
        String srcFilePath = scanner.nextLine();
        if(srcFilePath.isEmpty()) {
            srcFilePath = defaultSrcFilePath;
        }
        File srcFile = new File(srcFilePath);

        String defaultOutFilePath = currentRelativePath
                .resolve("encrypted.txt")
                .toAbsolutePath().toString();
        if (decrypt) {
            defaultOutFilePath = currentRelativePath
                    .resolve("decrypted.txt")
                    .toAbsolutePath().toString();
        }
        System.out.println("Enter output file path: (leave empty for default '" + defaultOutFilePath + "' path)");
        System.out.println("-------------------------\n");
        String outFilePath = scanner.nextLine();

        if(outFilePath.isEmpty()) {
            outFilePath = defaultOutFilePath;
        }
        File outFile = new File(outFilePath);

        if (decrypt) {
            System.out.println("Enter decryption key");
        } else {
            System.out.println("Enter encryption key");
        }
        System.out.println("-------------------------\n");

        int key = scanner.nextInt();

        Validator.isValidKey(key, alphabet);
        Validator.isFileExists(srcFile);

        if (decrypt) {
            System.out.println("Decrypting:");
        } else {
            System.out.println("Encrypting");
        }
        System.out.println("Input file: " + srcFile.getAbsolutePath());
        System.out.println("Output file: " + outFile.getAbsolutePath());
        System.out.println("With key: " + key);

        if (decrypt) {
            fileManager.processFile(
                    srcFile,
                    outFile,
                    (character) -> cipher.decrypt(character, key)
            );
        } else {
            fileManager.processFile(
                    srcFile,
                    outFile,
                    (character) -> cipher.encrypt(character, key)
            );
        }
    }
}
