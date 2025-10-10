import java.util.Scanner;

public class HW5_CSV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            input.append(line).append("\n");
        }
        String[][] data = parseCSV(input.toString());
        cleanData(data);
        analyzeData(data);

        sc.close();
    }

    static String[][] parseCSV(String text) {
        java.util.List<String[]> rows = new java.util.ArrayList<>();
        int i = 0;
        while (i < text.length()) {
            java.util.List<String> fields = new java.util.ArrayList<>();
            while (i < text.length() && text.charAt(i) != '\n') {
                StringBuilder field = new StringBuilder();
                boolean quoted = false;
                if (text.charAt(i) == '\"') {
                    quoted = true;
                    i++;
                }
                while (i < text.length()) {
                    char c = text.charAt(i);
                    if (quoted && c == '\"') {
                        i++;
                        break;
                    }
                    if (!quoted && c == ',') break;
                    field.append(c);
                    i++;
                }
                fields.add(field.toString());
                if (i < text.length() && text.charAt(i) == ',') i++;
            }
            rows.add(fields.toArray(new String[0]));
            while (i < text.length() && text.charAt(i) == '\n') i++;
        }
        return rows.toArray(new String[0][0]);
    }

    static void cleanData(String[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = data[i][j].trim();
            }
        }
    }

    static void analyzeData(String[][] data) {
        int cols = data[0].length;
        int rows = data.length;
        System.out.println("Formatted Table:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%-15s", data[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nColumn Statistics:");
        for (int j = 0; j < cols; j++) {
            boolean numeric = true;
            double min = Double.MAX_VALUE, max = Double.MIN_VALUE, sum = 0;
            int count = 0;
            java.util.Set<String> unique = new java.util.HashSet<>();
            for (int i = 1; i < rows; i++) {
                String val = data[i][j];
                if (val.isEmpty()) continue;
                unique.add(val);
                if (val.matches("-?\\d+(\\.\\d+)?")) {
                    double num = Double.parseDouble(val);
                    min = Math.min(min, num);
                    max = Math.max(max, num);
                    sum += num;
                    count++;
                } else {
                    numeric = false;
                }
            }
            System.out.println("Column " + (j + 1) + ":");
            if (numeric && count > 0) {
                System.out.printf("  Min: %.2f, Max: %.2f, Avg: %.2f\n", min, max, sum / count);
            } else {
                System.out.println("  Unique Values: " + unique.size());
            }
        }

        int missing = 0;
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (data[i][j].isEmpty()) missing++;
            }
        }
        int totalFields = (rows - 1) * cols;
        double completeness = 100.0 * (totalFields - missing) / totalFields;
        System.out.println("\nData Quality Report:");
        System.out.println("  Total Records: " + (rows - 1));
        System.out.println("  Missing Fields: " + missing);
        System.out.printf("  Completeness: %.2f%%\n", completeness);
    }
}
