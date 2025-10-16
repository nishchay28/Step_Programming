class Student {
    int id;
    String name;
}

public class LP2_GetClassMethod {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println("Class name: " + s.getClass().getName());
    }
}
