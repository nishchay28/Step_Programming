class Employee {
    private String empId;
    private String name;
    private double salary;

    public Employee(String empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void displayEmployee() {
        System.out.println("ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Salary: ₹" + salary);
    }
}

class Department {
    private String deptName;
    private Employee[] employees;
    private int count;

    public Department(String deptName, int size) {
        this.deptName = deptName;
        employees = new Employee[size];
        count = 0;
    }

    public void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count++] = e;
        }
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
        System.out.println("Total Employees: " + count);
        for (int i = 0; i < count; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            employees[i].displayEmployee();
        }
    }

    public double totalSalary() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += employees[i].getSalary();
        }
        return total;
    }
}

public class PP6_EmployeeManagement {
    public static void main(String[] args) {
        Employee e1 = new Employee("E101", "NISHCHAY", 55000);
        Employee e2 = new Employee("E102", "Aryan", 48000);
        Employee e3 = new Employee("E103", "Meera", 62000);

        Department d = new Department("Software Development", 5);
        d.addEmployee(e1);
        d.addEmployee(e2);
        d.addEmployee(e3);

        d.displayDepartment();
        System.out.println("\nTotal Salary Expense: " + d.totalSalary()+" Rs.");
    }
}