import java.util.Scanner;

class LB3_StringArray {

    // Method to count words based on spaces
    public static int countWords(String text) {
        int count = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') count++;
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

    // Method to find length of a string without using length()
    public static int getLength(String word) {
        int count = 0;
        try {
            while (true) {
                word.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    // Method to create 2D array of word and its length
    public static String[][] wordLengthTable(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    // Display method
    public static void displayTable(String[][] table) {
        System.out.printf("%-15s %-10s\n", "Word", "Length");
        System.out.println("----------------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.printf("%-15s %-10d\n", table[i][0], Integer.parseInt(table[i][1]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] words = manualSplit(input);
        String[][] table = wordLengthTable(words);

        displayTable(table);

        sc.close();
    }
}