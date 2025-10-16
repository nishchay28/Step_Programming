class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}

public class HW1_toString_GetClass {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Nishchay", 75000);
        Employee e2 = new Employee(102, "Aryan", 68000);

        System.out.println(e1.toString());
        System.out.println("Class: " + e1.getClass().getName());
        System.out.println(e2.toString());
        System.out.println("Class: " + e2.getClass().getName());
    }
}
