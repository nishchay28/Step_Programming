import java.util.Scanner;

class LB6_CharacterType {

    // Method to check character type
    public static String getCharType(char ch) {
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
            char lower = (ch >= 'A' && ch <= 'Z') ? (char)(ch + 32) : ch;
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to analyze string and return 2D array of character and type
    public static String[][] analyzeCharacters(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = getCharType(ch);
        }
        return result;
    }

    // Method to display result in tabular format
    public static void displayTable(String[][] table) {
        System.out.printf("%-10s %-15s\n", "Character", "Type");
        System.out.println("---------------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.printf("%-10s %-15s\n", table[i][0], table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] table = analyzeCharacters(input);
        displayTable(table);

        sc.close();
    }
}