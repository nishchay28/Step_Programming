import java.util.*;

public class PP3_ASCIIProcessor {

    public static void main(String[] args) {
        System.out.println("🛠 PRACTICE PROBLEM 3: ASCII Codes and Character Conversion");
        System.out.println("Task: Create a program that demonstrates ASCII character manipulation and conversion.");
        System.out.println("Operations:");
        System.out.println("1. Display each character and its ASCII code");
        System.out.println("2. Classify as uppercase, lowercase, digit, or special character");
        System.out.println("3. Show both cases for letters with ASCII values");
        System.out.println("4. Calculate ASCII difference between cases");
        System.out.println("5. Generate ASCII art using character codes");
        System.out.println("6. Apply Caesar cipher with shift +3");
        System.out.println("----------------------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        processCharacters(input);
        generateASCIIArt(input);
        System.out.println("Caesar Cipher (+3): " + caesarCipher(input, 3));
    }

    public static void processCharacters(String text) {
        for (char ch : text.toCharArray()) {
            int ascii = (int) ch;
            System.out.println("Character: " + ch + " | ASCII: " + ascii);

            if (Character.isUpperCase(ch)) {
                System.out.println("Type: Uppercase Letter");
                System.out.println("Lowercase: " + Character.toLowerCase(ch) + " | ASCII: " + (int) Character.toLowerCase(ch));
                System.out.println("Difference: " + (ascii - (int) Character.toLowerCase(ch)));
            } else if (Character.isLowerCase(ch)) {
                System.out.println("Type: Lowercase Letter");
                System.out.println("Uppercase: " + Character.toUpperCase(ch) + " | ASCII: " + (int) Character.toUpperCase(ch));
                System.out.println("Difference: " + ((int) Character.toUpperCase(ch) - ascii));
            } else if (Character.isDigit(ch)) {
                System.out.println("Type: Digit");
            } else {
                System.out.println("Type: Special Character");
            }
            System.out.println("---");
        }
    }

    public static void generateASCIIArt(String text) {
        System.out.println("ASCII Art:");
        for (char ch : text.toCharArray()) {
            int ascii = (int) ch;
            for (int i = 0; i < ascii % 10 + 1; i++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
