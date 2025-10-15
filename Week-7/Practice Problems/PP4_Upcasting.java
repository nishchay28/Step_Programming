public class PP4_Upcasting {
    public static void main(String[] args) {
        Person p = new Student("Alice", 20, "alice@uni.edu", "CS2021", "Computer Science");
        p.introduce();
        p.getContactInfo();
        // p.attendLecture(); // Compile error
        System.out.println("Name via Person reference: " + p.name);
    }
}

class Person {
    protected String name;
    protected int age;
    protected String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void introduce() {
        System.out.println("Hi! I'm " + name + ", " + age + " years old.");
    }

    public void getContactInfo() {
        System.out.println("Email: " + email);
    }
}

class Student extends Person {
    private String studentId;
    private String major;

    public Student(String name, int age, String email, String studentId, String major) {
        super(name, age, email);
        this.studentId = studentId;
        this.major = major;
    }

    public void attendLecture() {
        System.out.println(name + " is attending " + major + " lecture");
    }

    public void submitAssignment() {
        System.out.println("Assignment submitted by " + studentId);
    }
}
