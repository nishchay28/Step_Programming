import java.util.Scanner;

class HW1_BMI {

    // Method to calculate BMI and status for one person
    public static String[] calculateBMIStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status;

        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[] {
            String.format("%.2f", heightCm),
            String.format("%.2f", weight),
            String.format("%.2f", bmi),
            status
        };
    }

    // Method to process all 10 persons and return 2D result array
    public static String[][] processAllBMI(double[][] data) {
        String[][] result = new String[10][4];
        for (int i = 0; i < 10; i++) {
            result[i] = calculateBMIStatus(data[i][0], data[i][1]);
        }
        return result;
    }

    // Method to display the result in tabular format
    public static void displayResult(String[][] result) {
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%d\t%s\t\t%s\t\t%s\t%s\n",
                i + 1, result[i][0], result[i][1], result[i][2], result[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        String[][] result = processAllBMI(data);
        displayResult(result);

        sc.close();
    }
}