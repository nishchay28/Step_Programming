class University {
    String uniName = "SRM";

    class Department {
        void showDept() {
            System.out.println("Department of CSE at " + uniName);
        }
    }

    static class ExamCell {
        static void conductExam() {
            System.out.println("ExamCell is conducting exams.");
        }
    }
}

public class HW5_MemberStaticInnerClass {
    public static void main(String[] args) {
        University u = new University();
        University.Department d = u.new Department();
        d.showDept();

        University.ExamCell.conductExam();
    }
}
