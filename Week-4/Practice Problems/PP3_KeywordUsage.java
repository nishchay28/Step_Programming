public class PP3_KeywordUsage {
    final int maxScore = 100;

    public static void main(String[] args) {
        PP3_KeywordUsage kd = new PP3_KeywordUsage();
        kd.checkInstance(kd);

        Student s1 = new Student("Alice", 85);
        Student s2 = new Student("Bob", 92);

        System.out.println("Total Students: " + Student.count);
    }

    public void checkInstance(Object obj) {
        if (obj instanceof PP3_KeywordUsage) {
            System.out.println("Object is an instance of PP3_KeywordUsage");
        } else {
            System.out.println("Object is NOT an instance of PP3_KeywordUsage");
        }
    }
}

class Student {
    String name;
    int score;
    static int count = 0;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
        count++;
    }

    public final void display() {
        System.out.println("Name: " + name + ", Score: " + score);
    }
}