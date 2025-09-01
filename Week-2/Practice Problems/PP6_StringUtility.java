import java.util.*;

public class PP6_StringUtility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char target = scanner.next().charAt(0);
        scanner.close();

        System.out.println("Original String: " + input);
        System.out.println("Length (with spaces): " + input.length());

        String trimmed = input.trim();
        System.out.println("Trimmed String: " + trimmed);
        System.out.println("Length (trimmed): " + trimmed.length());

        System.out.println("Character at index 5: " + getCharAt(input, 5));
        System.out.println("Substring 'Programming': " + extractSubstring(input, "Programming"));
        System.out.println("Index of 'Fun': " + input.indexOf("Fun"));
        System.out.println("Contains 'Java': " + input.contains("Java"));
        System.out.println("Starts with 'Java' (trimmed): " + trimmed.startsWith("Java"));
        System.out.println("Ends with '!': " + input.endsWith("!"));
        System.out.println("Uppercase: " + input.toUpperCase());
        System.out.println("Lowercase: " + input.toLowerCase());

        System.out.println("Vowel Count: " + countVowels(input));
        System.out.print("Occurrences of '" + target + "': ");
        findAllOccurrences(input, target);
    }

    public static char getCharAt(String text, int index) {
        return text.charAt(index);
    }

    public static String extractSubstring(String text, String word) {
        int start = text.indexOf(word);
        if (start == -1) return "";
        return text.substring(start, start + word.length());
    }

    public static int countVowels(String text) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) count++;
        }
        return count;
    }

    public static void findAllOccurrences(String text, char target) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}