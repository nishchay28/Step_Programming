import java.util.Scanner;

public class HW4_TextCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine().replaceAll(" ", "");
        if (!isValid(expr)) {
            System.out.println("Invalid Expression");

            sc.close();
            return;
        }
        String result = evaluate(expr);
        System.out.println("Original Expression: " + expr);
        System.out.println("Final Result: " + result);

        sc.close();
    }

    static boolean isValid(String expr) {
        int balance = 0;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (!(Character.isDigit(c) || "+-*/()".indexOf(c) != -1)) return false;
            if (c == '(') balance++;
            if (c == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    static String evaluate(String expr) {
        while (expr.contains("(")) {
            int close = expr.indexOf(')');
            int open = expr.lastIndexOf('(', close);
            String sub = expr.substring(open + 1, close);
            String val = compute(sub);
            expr = expr.substring(0, open) + val + expr.substring(close + 1);
        }
        return compute(expr);
    }

    static String compute(String expr) {
        StringBuilder sb = new StringBuilder(expr);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '-' && (i == 0 || "+-*/(".indexOf(sb.charAt(i - 1)) != -1)) {
                sb.insert(i, '0');
                i++;
            }
        }
        String[] tokens = tokenize(sb.toString());
        tokens = process(tokens, "*", "/");
        tokens = process(tokens, "+", "-");
        return tokens[0];
    }

    static String[] tokenize(String expr) {
        StringBuilder num = new StringBuilder();
        java.util.List<String> list = new java.util.ArrayList<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                if (num.length() > 0) {
                    list.add(num.toString());
                    num.setLength(0);
                }
                list.add(String.valueOf(c));
            }
        }
        if (num.length() > 0) list.add(num.toString());
        return list.toArray(new String[0]);
    }

    static String[] process(String[] tokens, String op1, String op2) {
        java.util.List<String> result = new java.util.ArrayList<>();
        int i = 0;
        while (i < tokens.length) {
            if (tokens[i].equals(op1) || tokens[i].equals(op2)) {
                int a = Integer.parseInt(result.remove(result.size() - 1));
                int b = Integer.parseInt(tokens[i + 1]);
                int res = tokens[i].equals(op1) ? a * b : a / b;
                result.add(String.valueOf(res));
                i += 2;
            } else {
                result.add(tokens[i]);
                i++;
            }
        }
        return result.toArray(new String[0]);
    }
}
