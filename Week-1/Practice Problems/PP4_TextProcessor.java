import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PP4_TextProcessor {
    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");
        StringBuilder cleaned = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                cleaned.append(Character.toUpperCase(word.charAt(0)))
                       .append(word.substring(1).toLowerCase())
                       .append(" ");
            }
        }
        return cleaned.toString().trim();
    }

    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int sentenceCount = text.split("[.!?]").length;
        int charCount = text.replaceAll("\\s+", "").length();

        String longestWord = "";
        Map<Character, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (word.length() > longestWord.length()) longestWord = word;
            for (char c : word.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    freq.put(c, freq.getOrDefault(c, 0) + 1);
                }
            }
        }

        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                mostCommonChar = entry.getKey();
                maxFreq = entry.getValue();
            }
        }

        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Characters (no spaces): " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: " + mostCommonChar);
    }

    public static String[] getWordsSorted(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = cleaned.split("\\s+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();

        String cleaned = cleanInput(input);
        System.out.println("\n--- Cleaned Text ---");
        System.out.println(cleaned);

        System.out.println("\n--- Text Analysis ---");
        analyzeText(cleaned);

        System.out.println("\n--- Sorted Words ---");
        String[] sortedWords = getWordsSorted(cleaned);
        for (String word : sortedWords) {
            System.out.println(word);
        }

        System.out.print("\nSearch for a word: ");
        String search = scanner.nextLine().trim();
        boolean found = Arrays.stream(sortedWords)
                              .anyMatch(w -> w.equalsIgnoreCase(search));
        System.out.println(found ? "Word found." : "Word not found.");

        scanner.close();
    }
}
