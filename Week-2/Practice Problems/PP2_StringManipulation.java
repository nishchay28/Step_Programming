import java.util.*;

public class PP2_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String trimmed = input.trim();
        String replacedSpaces = trimmed.replace(" ", "_");
        String noDigits = trimmed.replaceAll("\\d", "");
        String[] words = trimmed.split("\\s+");
        String joined = String.join(" | ", words);

        System.out.println("Trimmed: " + trimmed);
        System.out.println("Replaced Spaces: " + replacedSpaces);
        System.out.println("Removed Digits: " + noDigits);
        System.out.println("Words Array: " + Arrays.toString(words));
        System.out.println("Joined with '|': " + joined);

        String noPunct = removePunctuation(trimmed);
        String capitalized = capitalizeWords(noPunct);
        String reversed = reverseWordOrder(noPunct);

        System.out.println("No Punctuation: " + noPunct);
        System.out.println("Capitalized Words: " + capitalized);
        System.out.println("Reversed Word Order: " + reversed);

        countWordFrequency(noPunct);
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("[\\p{Punct}]", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
            }
        }
        return result.toString().trim();
    }

    public static String reverseWordOrder(String text) {
        String[] words = text.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> freq = new LinkedHashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}