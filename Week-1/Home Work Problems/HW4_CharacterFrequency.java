import java.util.Scanner;

class HW4_CharacterFrequency {

    // Method to calculate character frequencies using ASCII indexing
    public static String[][] getCharacterFrequencies(String text) {
        int[] freq = new int[256]; // ASCII range

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // Prepare result array with only characters that appear
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] > 0) {
                count++;
                freq[text.charAt(i)] = -freq[text.charAt(i)]; // Mark as processed
            }
        }

        String[][] result = new String[count][2];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int ascii = (int) ch;
            if (freq[ascii] < 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(-freq[ascii]);
                freq[ascii] = 0; // Reset to avoid duplicates
                index++;
            }
        }

        return result;
    }

    // Method to display the 2D frequency array
    public static void displayFrequencies(String[][] result) {
        System.out.println("Character\tFrequency");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String input = sc.nextLine();

        String[][] frequencies = getCharacterFrequencies(input);
        displayFrequencies(frequencies);

        sc.close();
    }
}