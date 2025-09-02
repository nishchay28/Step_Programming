import java.util.Scanner;

class LP6_CharacterType {

    public static String getCharacterType(char ch) {
        ch = Character.toLowerCase(ch);
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    public static String[][] analyzeCharacters(String input) {
        String[][] result = new String[input.length()][2];
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = getCharacterType(ch);
        }
        return result;
    }

    public static void displayResult(String[][] data) {
        System.out.println("Character\tType");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] result = analyzeCharacters(input);
        displayResult(result);

        sc.close();
    }
}