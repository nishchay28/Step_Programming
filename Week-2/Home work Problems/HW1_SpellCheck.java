import java.util.Scanner;

class HW1_SpellCheck {

    public static String[] extractWords(String sentence) {
        int len = sentence.length();
        String[] temp = new String[len];
        int count = 0, start = 0;

        for (int i = 0; i <= len; i++) {
            if (i == len || sentence.charAt(i) == ' ' || !Character.isLetter(sentence.charAt(i))) {
                if (start < i) {
                    temp[count++] = sentence.substring(start, i);
                }
                start = i + 1;
            }
        }

        String[] words = new String[count];
        System.arraycopy(temp, 0, words, 0, count);
        return words;
    }

    public static int stringDistance(String a, String b) {
        int lenA = a.length(), lenB = b.length();
        int diff = Math.abs(lenA - lenB);
        int minLen = Math.min(lenA, lenB);

        for (int i = 0; i < minLen; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }

    public static String getClosestMatch(String word, String[] dictionary) {
        int minDist = Integer.MAX_VALUE;
        String suggestion = word;

        for (String dictWord : dictionary) {
            int dist = stringDistance(word.toLowerCase(), dictWord.toLowerCase());
            if (dist < minDist) {
                minDist = dist;
                suggestion = dictWord;
            }
        }

        return (minDist <= 2) ? suggestion : "No Suggestion";
    }

    public static void displaySpellCheck(String[] words, String[] dictionary) {
        System.out.println("Word\t\tSuggestion\tDistance\tStatus");
        for (String word : words) {
            String suggestion = getClosestMatch(word, dictionary);
            int dist = suggestion.equals("No Suggestion") ? -1 : stringDistance(word, suggestion);
            String status = (dist == 0) ? "Correct" : "Misspelled";
            System.out.println(word + "\t\t" + suggestion + "\t\t" + ((dist == -1) ? "-" : dist) + "\t\t" + status);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        System.out.print("Enter number of dictionary words: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] dictionary = new String[n];
        System.out.println("Enter dictionary words:");
        for (int i = 0; i < n; i++) {
            dictionary[i] = sc.nextLine();
        }

        String[] words = extractWords(sentence);
        displaySpellCheck(words, dictionary);

        sc.close();
    }
}