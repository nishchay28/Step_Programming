import java.util.*;

public class HW4_StudentGrades {
    static int totalStudents = 0;
    static String schoolName = "SRM School";
    static String[] gradingScale = {"A", "B", "C", "D", "F"};
    static double passPercentage = 40.0;

    static class Subject {
        String subjectCode, subjectName, instructor;
        int credits;

        Subject(String code, String name, int credits, String instructor) {
            this.subjectCode = code;
            this.subjectName = name;
            this.credits = credits;
            this.instructor = instructor;
        }
    }

    static class Student {
        String studentId, studentName, className;
        String[] subjects;
        double[][] marks;
        double gpa;

        Student(String id, String name, String cls, String[] subs) {
            this.studentId = id;
            this.studentName = name;
            this.className = cls;
            this.subjects = subs;
            this.marks = new double[subs.length][2];
            totalStudents++;
        }

        void addMarks(String subject, double mark) {
            for (int i = 0; i < subjects.length; i++) {
                if (subjects[i].equals(subject)) {
                    marks[i][0] = mark;
                    break;
                }
            }
        }

        void calculateGPA() {
            double total = 0;
            for (int i = 0; i < subjects.length; i++) total += marks[i][0];
            gpa = total / subjects.length;
        }

        void generateReportCard() {
            System.out.println("Report for " + studentName);
            for (int i = 0; i < subjects.length; i++) {
                String grade = marks[i][0] >= 90 ? "A" : marks[i][0] >= 80 ? "B" : marks[i][0] >= 70 ? "C" : marks[i][0] >= 60 ? "D" : "F";
                System.out.println(subjects[i] + ": " + marks[i][0] + " (" + grade + ")");
            }
            System.out.println("GPA: " + gpa);
        }

        boolean checkPromotionEligibility() {
            return gpa >= passPercentage;
        }

        static void setGradingScale(String[] scale) {
            gradingScale = scale;
        }

        static double calculateClassAverage(Student[] students) {
            double total = 0;
            for (Student s : students) total += s.gpa;
            return total / students.length;
        }

        static Student[] getTopPerformers(Student[] students, int count) {
            Arrays.sort(students, (a, b) -> Double.compare(b.gpa, a.gpa));
            return Arrays.copyOfRange(students, 0, count);
        }

        static void generateSchoolReport(Student[] students) {
            System.out.println("School Report for " + schoolName);
            for (Student s : students) s.generateReportCard();
        }
    }

    public static void main(String[] args) {
        String[] subs = {"Math", "Physics", "Chemistry"};
        Student s1 = new Student("S1", "NISHCHAY", "12A", subs);
        s1.addMarks("Math", 95);
        s1.addMarks("Physics", 88);
        s1.addMarks("Chemistry", 76);
        s1.calculateGPA();
        s1.generateReportCard();
        System.out.println("Promoted: " + s1.checkPromotionEligibility());
    }
}
