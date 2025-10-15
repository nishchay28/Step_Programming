class LibraryUser {
    String name;

    public LibraryUser(String name) {
        this.name = name;
    }

    public void logEntry() {
        System.out.println(name + " entered the library.");
    }

    public void displayInfo() {
        System.out.println("User: " + name);
    }
}

class Student extends LibraryUser {
    public Student(String name) {
        super(name);
    }

    public void borrowBook() {
        System.out.println(name + " borrowed a book.");
    }
}

class Faculty extends LibraryUser {
    public Faculty(String name) {
        super(name);
    }

    public void reserveBook() {
        System.out.println(name + " reserved a book.");
    }
}

class Guest extends LibraryUser {
    public Guest(String name) {
        super(name);
    }

    public void browseBooks() {
        System.out.println(name + " is browsing books.");
    }
}

public class LP4_Upcasting {
    public static void main(String[] args) {
        LibraryUser[] users = {
            new Student("Alice"),
            new Faculty("Bob"),
            new Guest("Charlie")
        };

        for (LibraryUser u : users) {
            u.logEntry();
            u.displayInfo();
        }
    }
}
