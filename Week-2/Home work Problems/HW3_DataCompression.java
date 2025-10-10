import java.util.Scanner;

public class HW3_DataCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char[] chars = new char[text.length()];
        int[] freq = new int[text.length()];
        int uniqueCount = countFrequency(text, chars, freq);
        String[] codes = generateCodes(freq, uniqueCount);
        String compressed = compressText(text, chars, codes, uniqueCount);
        String decompressed = decompressText(compressed, chars, codes, uniqueCount);
        displayAnalysis(text, chars, freq, codes, compressed, decompressed, uniqueCount);

        sc.close();
    }

    static int countFrequency(String text, char[] chars, int[] freq) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < count; j++) {
                if (chars[j] == c) {
                    freq[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                chars[count] = c;
                freq[count] = 1;
                count++;
            }
        }
        return count;
    }

    static String[] generateCodes(int[] freq, int count) {
        String[] codes = new String[count];
        for (int i = 0; i < count; i++) {
            codes[i] = String.valueOf((char) (33 + i)); // ASCII symbols starting from '!'
        }
        return codes;
    }

    static String compressText(String text, char[] chars, String[] codes, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (int j = 0; j < count; j++) {
                if (chars[j] == c) {
                    sb.append(codes[j]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    static String decompressText(String compressed, char[] chars, String[] codes, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < compressed.length(); i++) {
            String code = String.valueOf(compressed.charAt(i));
            for (int j = 0; j < count; j++) {
                if (codes[j].equals(code)) {
                    sb.append(chars[j]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    static void displayAnalysis(String original, char[] chars, int[] freq, String[] codes, String compressed, String decompressed, int count) {
        System.out.println("Character Frequency Table:");
        for (int i = 0; i < count; i++) {
            System.out.println(chars[i] + " : " + freq[i]);
        }
        System.out.println("\nCompression Mapping:");
        for (int i = 0; i < count; i++) {
            System.out.println(chars[i] + " -> " + codes[i]);
        }
        System.out.println("\nOriginal Text: " + original);
        System.out.println("Compressed Text: " + compressed);
        System.out.println("Decompressed Text: " + decompressed);
        double ratio = (double) compressed.length() / original.length() * 100;
        System.out.printf("Compression Efficiency: %.2f%%\n", ratio);
    }
}
