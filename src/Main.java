import java.util.Scanner;

/**
 * java-encoder
 * @author @Alisher
 */

public class Main {
    static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Шифровать");
        System.out.println("2. Расшифровать");
        String command = scanner.nextLine();
        if (command.equals("1")){
            System.out.print("Ваш текст: ");
            String text = scanner.nextLine();
            System.out.println("Шифрованный текст: " + encode(text));
        } else if (command.equals("2")) {
            System.out.print("Ваш текст: ");
            String text = scanner.nextLine();
            System.out.println("Расшифрованный текст: " + decode(text));
        }
    }


    /**
     * @param input Передается текст, которого надо расшифровать
     * @return Возвращается расшифрованный текст
     */
    public static String decode(String input){
        StringBuilder builder = new StringBuilder();
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (!ALPHABET.contains(String.valueOf(character))) {
                builder.append(character);
                continue;
            }
            int charPosition = ALPHABET.indexOf(character);
            int keyVal = (charPosition - 3) % ALPHABET.length();
            if (keyVal < 0) {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            builder.append(replaceVal);
        }
        return builder.toString();
    }

    /**
     * @param input Передается текст, которого надо шифровать
     * @return Возвращается шифрованный текст
     */
    public static String encode(String input) {
        StringBuilder builder = new StringBuilder();
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (!ALPHABET.contains(String.valueOf(character))) {
                builder.append(character);
                continue;
            }
            int charPosition = ALPHABET.indexOf(character);
            int keyVal = (charPosition + 3) % ALPHABET.length();
            char replaceVal = ALPHABET.charAt(keyVal);
            builder.append(replaceVal);
        }
        return builder.toString();
    }
}
