import java.util.Scanner;

public class LP2_ASCIIOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String upperManual = toUpperCaseASCII(input);
        String lowerManual = toLowerCaseASCII(input);
        String titleManual = toTitleCaseASCII(input);

        String upperBuiltIn = input.toUpperCase();
        String lowerBuiltIn = input.toLowerCase();

        System.out.println("Manual Uppercase: " + upperManual);
        System.out.println("Built-in Uppercase: " + upperBuiltIn);
        System.out.println("Match: " + upperManual.equals(upperBuiltIn));

        System.out.println("Manual Lowercase: " + lowerManual);
        System.out.println("Built-in Lowercase: " + lowerBuiltIn);
        System.out.println("Match: " + lowerManual.equals(lowerBuiltIn));

        System.out.println("Manual Title Case: " + titleManual);

        sc.close();
    }

    public static String toUpperCaseASCII(String text) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char)(ch - 32));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String toLowerCaseASCII(String text) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char)(ch + 32));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String toTitleCaseASCII(String text) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                sb.append(ch);
                newWord = true;
            } else if (newWord && ch >= 'a' && ch <= 'z') {
                sb.append((char)(ch - 32));
                newWord = false;
            } else if (!newWord && ch >= 'A' && ch <= 'Z') {
                sb.append((char)(ch + 32));
            } else {
                sb.append(ch);
                newWord = false;
            }
        }
        return sb.toString();
    }
}
