import java.util.HashSet;

public class Employee {
    private String empCode;
    private String name;

    public Employee(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Employee) {
            Employee other = (Employee) obj;
            return this.empCode.equals(other.empCode);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return empCode.hashCode();
    }

    @Override
    public String toString() {
        return "Employee Code: " + empCode + ", Name: " + name;
    }
}

public class PP2_EmployeeAuth {
    public static void main(String[] args) {
        Employee e1 = new Employee("BL001", "Ritika");
        Employee e2 = new Employee("BL001", "Ritika S.");

        System.out.println("== comparison: " + (e1 == e2));
        System.out.println("equals comparison: " + e1.equals(e2));

        HashSet<Employee> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        System.out.println("HashSet size: " + set.size());
    }
}
