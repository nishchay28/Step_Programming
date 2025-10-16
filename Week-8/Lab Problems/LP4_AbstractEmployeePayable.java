abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();
}

interface Payable {
    void generatePaySlip();
}

class Manager extends Employee implements Payable {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return salary * 0.2;
    }

    public void generatePaySlip() {
        System.out.println("Pay Slip for: " + name);
        System.out.println("Salary: ₹" + salary);
        System.out.println("Bonus: ₹" + calculateBonus());
    }
}

public class LP4_AbstractEmployeePayable {
    public static void main(String[] args) {
        Manager m = new Manager("Nishchay", 50000);
        m.generatePaySlip();
    }
}
