import java.util.Scanner;

public class LP3_StringPerformance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iterations = sc.nextInt();

        long stringTime = testStringConcat(iterations);
        long builderTime = testStringBuilder(iterations);
        long bufferTime = testStringBuffer(iterations);

        System.out.println("Method\t\tTime(ms)");
        System.out.println("String\t\t" + stringTime);
        System.out.println("StringBuilder\t" + builderTime);
        System.out.println("StringBuffer\t" + bufferTime);

        sc.close();
    }

    public static long testStringConcat(int n) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + "x";
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long testStringBuilder(int n) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("x");
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long testStringBuffer(int n) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("x");
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
