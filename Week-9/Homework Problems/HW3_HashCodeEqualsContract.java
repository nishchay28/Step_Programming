import java.util.HashSet;
import java.util.Objects;

class Student {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student s = (Student) obj;
        return rollNo == s.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }
}

public class HW3_HashCodeEqualsContract {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Nishchay");
        Student s2 = new Student(101, "Aryan");

        HashSet<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);

        System.out.println("HashSet size: " + set.size());
    }
}
