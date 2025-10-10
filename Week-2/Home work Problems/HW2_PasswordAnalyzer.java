import java.util.*;

public class HW2_PasswordAnalyzer {

    // Method to analyze password strength
    public static Map<String, Object> analyzePassword(String password) {
        int upper = 0, lower = 0, digits = 0, special = 0;
        String[] commonPatterns = {"123", "abc", "qwerty"};
        boolean hasCommonPattern = false;

        for (char ch : password.toCharArray()) {
            int ascii = (int) ch;
            if (ascii >= 65 && ascii <= 90) upper++;
            else if (ascii >= 97 && ascii <= 122) lower++;
            else if (ascii >= 48 && ascii <= 57) digits++;
            else if (ascii >= 33 && ascii <= 126) special++;
        }

        for (String pattern : commonPatterns) {
            if (password.toLowerCase().contains(pattern)) {
                hasCommonPattern = true;
                break;
            }
        }

        int score = 0;
        score += Math.max(0, (password.length() - 8)) * 2;
        score += (upper > 0 ? 10 : 0) + (lower > 0 ? 10 : 0) + (digits > 0 ? 10 : 0) + (special > 0 ? 10 : 0);
        if (hasCommonPattern) score -= 10;

        String strength = score <= 20 ? "Weak" : score <= 50 ? "Medium" : "Strong";

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("Password", password);
        result.put("Length", password.length());
        result.put("Uppercase", upper);
        result.put("Lowercase", lower);
        result.put("Digits", digits);
        result.put("SpecialChars", special);
        result.put("Score", score);
        result.put("Strength", strength);

        return result;
    }

    // Method to generate a strong password
    public static String generateStrongPassword(int length) {
        if (length < 8) length = 8;

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append(upper.charAt(rand.nextInt(upper.length())));
        sb.append(lower.charAt(rand.nextInt(lower.length())));
        sb.append(digits.charAt(rand.nextInt(digits.length())));
        sb.append(special.charAt(rand.nextInt(special.length())));

        String allChars = upper + lower + digits + special;
        for (int i = sb.length(); i < length; i++) {
            sb.append(allChars.charAt(rand.nextInt(allChars.length())));
        }

        // Shuffle characters
        List<Character> passwordChars = new ArrayList<>();
        for (char c : sb.toString().toCharArray()) passwordChars.add(c);
        Collections.shuffle(passwordChars);

        StringBuilder shuffled = new StringBuilder();
        for (char c : passwordChars) shuffled.append(c);

        return shuffled.toString();
    }

    // Method to display analysis results
    public static void displayAnalysis(List<Map<String, Object>> analyses) {
        System.out.printf("%-15s %-6s %-10s %-10s %-8s %-12s %-6s %-8s%n",
                "Password", "Len", "Uppercase", "Lowercase", "Digits", "SpecialChars", "Score", "Strength");
        for (Map<String, Object> result : analyses) {
            System.out.printf("%-15s %-6d %-10d %-10d %-8d %-12d %-6d %-8s%n",
                    result.get("Password"),
                    result.get("Length"),
                    result.get("Uppercase"),
                    result.get("Lowercase"),
                    result.get("Digits"),
                    result.get("SpecialChars"),
                    result.get("Score"),
                    result.get("Strength"));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Map<String, Object>> analyses = new ArrayList<>();

        System.out.println("Enter number of passwords to analyze:");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < count; i++) {
            System.out.println("Enter password #" + (i + 1) + ":");
            String password = scanner.nextLine();
            analyses.add(analyzePassword(password));
        }

        displayAnalysis(analyses);

        System.out.println("\nDo you want to generate a strong password? (yes/no)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter desired password length:");
            int length = scanner.nextInt();
            String newPassword = generateStrongPassword(length);
            System.out.println("Generated Password: " + newPassword);
            Map<String, Object> newAnalysis = analyzePassword(newPassword);
            displayAnalysis(Collections.singletonList(newAnalysis));
        }

        scanner.close();
    }
}
