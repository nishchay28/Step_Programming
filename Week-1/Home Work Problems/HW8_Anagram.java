import java.util.Scanner;

public class HW8_Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            boolean result = checkAnagram(str1, str2);
            System.out.println(result ? "Anagram" : "Not Anagram");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] asciiCount = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            asciiCount[s1.charAt(i)]++;
            asciiCount[s2.charAt(i)]--;
        }
        for (int count : asciiCount) {
            if (count != 0) return false;
        }
        return true;
    }
}