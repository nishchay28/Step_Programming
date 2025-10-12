import java.util.*;

public class HW6_LibrarySystem {
    static int totalBooks = 0;
    static String libraryName = "SRM Library";

    static class Book {
        String bookId, title, author;
        boolean isAvailable;

        Book(String id, String title, String author) {
            this.bookId = id;
            this.title = title;
            this.author = author;
            this.isAvailable = true;
            totalBooks++;
        }
    }

    static class Member {
        String memberId, name;
        String[] borrowedBooks = new String[5];
        int borrowCount = 0;

        Member(String id, String name) {
            this.memberId = id;
            this.name = name;
        }

        void borrowBook(Book b) {
            if (b.isAvailable && borrowCount < 5) {
                borrowedBooks[borrowCount++] = b.title;
                b.isAvailable = false;
            }
        }

        void returnBook(Book b) {
            for (int i = 0; i < borrowCount; i++) {
                if (borrowedBooks[i].equals(b.title)) {
                    b.isAvailable = true;
                    for (int j = i; j < borrowCount - 1; j++) borrowedBooks[j] = borrowedBooks[j + 1];
                    borrowCount--;
                    break;
                }
            }
        }

        void displayBorrowedBooks() {
            System.out.println("Borrowed by " + name + ":");
            for (int i = 0; i < borrowCount; i++) System.out.println(borrowedBooks[i]);
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("B1", "Java Basics", "Hemasri");
        Book b2 = new Book("B2", "OOP Concepts", "NISHCHAY");
        Member m1 = new Member("M1", "NISHCHAY");

        m1.borrowBook(b1);
        m1.borrowBook(b2);
        m1.displayBorrowedBooks();
        m1.returnBook(b1);
        m1.displayBorrowedBooks();
    }
}
