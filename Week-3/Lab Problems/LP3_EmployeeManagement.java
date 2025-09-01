import java.util.*;

class Employee {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    private static int totalEmployees = 0;

    // Constructor for full-time employee
    public Employee(String name, String dept, double salary) {
        this.empId = generateEmpId();
        this.empName = name;
        this.department = dept;
        this.baseSalary = salary;
        this.empType = "Full-Time";
        totalEmployees++;
    }

    // Constructor for part-time employee
    public Employee(String name, String dept, double hourlyRate, int hours) {
        this.empId = generateEmpId();
        this.empName = name;
        this.department = dept;
        this.baseSalary = hourlyRate * hours;
        this.empType = "Part-Time";
        totalEmployees++;
    }

    // Constructor for contract employee
    public Employee(String name, String dept, double fixedAmount, boolean isContract) {
        this.empId = generateEmpId();
        this.empName = name;
        this.department = dept;
        this.baseSalary = fixedAmount;
        this.empType = "Contract";
        totalEmployees++;
    }

    // Static method to generate unique employee ID
    public static String generateEmpId() {
        return "EMP" + String.format("%03d", totalEmployees + 1);
    }

    // Overloaded method to calculate salary
    public double calculateSalary() {
        if (empType.equals("Full-Time")) {
            return baseSalary + 5000; // Bonus
        } else if (empType.equals("Part-Time")) {
            return baseSalary;
        } else {
            return baseSalary;
        }
    }

    // Overloaded method to calculate tax
    public double calculateTax() {
        if (empType.equals("Full-Time")) {
            return calculateSalary() * 0.10;
        } else if (empType.equals("Part-Time")) {
            return calculateSalary() * 0.05;
        } else {
            return calculateSalary() * 0.08;
        }
    }

    // Method to generate payslip
    public void generatePaySlip() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Department: " + department);
        System.out.println("Type: " + empType);
        System.out.println("Salary: " + String.format("%.2f", calculateSalary()));
        System.out.println("Tax: " + String.format("%.2f", calculateTax()));
        System.out.println("Net Pay: " + String.format("%.2f", calculateSalary() - calculateTax()));
    }

    // Method to display employee info
    public void displayEmployeeInfo() {
        System.out.println("ID: " + empId + ", Name: " + empName + ", Dept: " + department + ", Type: " + empType);
    }

    // Static method to get total employees
    public static int getTotalEmployees() {
        return totalEmployees;
    }
}

public class LP3_EmployeeManagement {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "HR", 50000);
        Employee e2 = new Employee("Bob", "IT", 200, 120); // hourly rate × hours
        Employee e3 = new Employee("Charlie", "Finance", 60000, true); // contract

        e1.generatePaySlip();
        System.out.println();
        e2.generatePaySlip();
        System.out.println();
        e3.generatePaySlip();
        System.out.println();

        System.out.println("Total Employees: " + Employee.getTotalEmployees());
    }
}
