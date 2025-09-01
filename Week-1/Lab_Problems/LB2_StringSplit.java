import java.util.Scanner;

class LB2_StringSplit {
    // Method to count words based on spaces
    public static int countWords(String text) {
        int count = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    // Method to split string manually using charAt()
    public static String[] manualSplit(String text) {
        int wordCount = countWords(text);
        String[] words = new String[wordCount];
        int start = 0, wordIndex = 0;

        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == ' ') {
                String word = "";
                for (int j = start; j < i; j++) {
                    word += text.charAt(j);
                }
                words[wordIndex++] = word;
                start = i + 1;
            }
        }
        return words;
    }

    // Method to compare two string arrays
    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] manual = manualSplit(input);
        String[] builtin = input.split(" ");

        System.out.println("Manual Split:");
        for (String word : manual) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in Split:");
        for (String word : builtin) {
            System.out.println(word);
        }

        boolean match = compareArrays(manual, builtin);
        System.out.println("\nDo both methods produce the same result? " + match);

        sc.close();
    }
}