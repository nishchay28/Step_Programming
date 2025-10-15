class Course {
    String title, instructor;
    String enrollmentDate;

    public Course(String title, String instructor, String enrollmentDate) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = enrollmentDate;
    }

    public void showProgress() {
        System.out.println("Progress for " + title + " by " + instructor);
    }
}

class VideoCourse extends Course {
    int percentComplete;
    int watchTime;

    public VideoCourse(String title, String instructor, String enrollmentDate, int percentComplete, int watchTime) {
        super(title, instructor, enrollmentDate);
        this.percentComplete = percentComplete;
        this.watchTime = watchTime;
    }

    @Override
    public void showProgress() {
        System.out.println(title + ": " + percentComplete + "% watched, " + watchTime + " mins");
    }
}

class InteractiveCourse extends Course {
    int quizScore;
    int projectsDone;

    public InteractiveCourse(String title, String instructor, String enrollmentDate, int quizScore, int projectsDone) {
        super(title, instructor, enrollmentDate);
        this.quizScore = quizScore;
        this.projectsDone = projectsDone;
    }

    @Override
    public void showProgress() {
        System.out.println(title + ": Quiz " + quizScore + "%, Projects: " + projectsDone);
    }
}

class ReadingCourse extends Course {
    int pagesRead;
    int notesTaken;

    public ReadingCourse(String title, String instructor, String enrollmentDate, int pagesRead, int notesTaken) {
        super(title, instructor, enrollmentDate);
        this.pagesRead = pagesRead;
        this.notesTaken = notesTaken;
    }

    @Override
    public void showProgress() {
        System.out.println(title + ": " + pagesRead + " pages read, " + notesTaken + " notes");
    }
}

class CertificationCourse extends Course {
    int examAttempts;
    boolean certified;

    public CertificationCourse(String title, String instructor, String enrollmentDate, int examAttempts, boolean certified) {
        super(title, instructor, enrollmentDate);
        this.examAttempts = examAttempts;
        this.certified = certified;
    }

    @Override
    public void showProgress() {
        System.out.println(title + ": Attempts = " + examAttempts + ", Certified = " + certified);
    }
}

public class HW2_OnlineLearningPlatform {
    public static void main(String[] args) {
        Course[] courses = {
            new VideoCourse("Java Basics", "Alice", "2023-01-01", 80, 120),
            new InteractiveCourse("Python Projects", "Bob", "2023-02-01", 90, 3),
            new ReadingCourse("History 101", "Carol", "2023-03-01", 150, 20),
            new CertificationCourse("AWS Cert", "Dave", "2023-04-01", 2, true)
        };

        for (Course c : courses) {
            c.showProgress();
        }
    }
}
