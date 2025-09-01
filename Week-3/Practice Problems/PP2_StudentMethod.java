public class PP2_StudentMethod {
    private String studentId;
    private String name;
    private double grade;
    private String course;

    public PP2_StudentMethod() {
        studentId = "";
        name = "";
        grade = 0.0;
        course = "";
    }

    public PP2_StudentMethod(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String calculateLetterGrade() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

    public void displayStudent() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("Course: " + course);
        System.out.println("Letter Grade: " + calculateLetterGrade());
    }

    public static void main(String[] args) {
        PP2_StudentMethod s1 = new PP2_StudentMethod();
        s1.setStudentId("S101");
        s1.setName("NISHCHAY");
        s1.setGrade(90.5);
        s1.setCourse("OOP Fundamentals");

        PP2_StudentMethod s2 = new PP2_StudentMethod("S102", "Aryan", 72.0, "OOP Fundamentals");

        System.out.println("Student 1:");
        s1.displayStudent();

        System.out.println("\nStudent 2:");
        s2.displayStudent();
    }
}
