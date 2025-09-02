import java.util.Scanner;

public class LP4_Encryption {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        int shift = sc.nextInt();

        String encrypted = encryptText(original, shift);
        String decrypted = decryptText(encrypted, shift);
        boolean isValid = original.equals(decrypted);

        System.out.println("Original Text: " + original);
        displayASCII(original);

        System.out.println("Encrypted Text: " + encrypted);
        displayASCII(encrypted);

        System.out.println("Decrypted Text: " + decrypted);
        System.out.println("Valid Decryption: " + isValid);

        sc.close();
    }

    public static String encryptText(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char)((ch - 'A' + shift) % 26 + 'A'));
            } else if (ch >= 'a' && ch <= 'z') {
                sb.append((char)((ch - 'a' + shift) % 26 + 'a'));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String decryptText(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char)((ch - 'A' - shift + 26) % 26 + 'A'));
            } else if (ch >= 'a' && ch <= 'z') {
                sb.append((char)((ch - 'a' - shift + 26) % 26 + 'a'));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void displayASCII(String text) {
        for (char ch : text.toCharArray()) {
            System.out.print((int)ch + " ");
        }
        System.out.println();
    }
}
