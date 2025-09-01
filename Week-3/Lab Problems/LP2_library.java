import java.util.*;

class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private static int totalBooks = 0;
    private static int availableBooks = 0;

    public Book(String title, String author) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    public static String generateBookId() {
        return "B" + String.format("%03d", totalBooks + 1);
    }

    public void issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public String getBookId() {
        return bookId;
    }

    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public static int getAvailableBooks() {
        return availableBooks;
    }
}

class Member {
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;
    private static int totalMembers = 0;

    public Member(String name) {
        this.memberId = generateMemberId();
        this.memberName = name;
        this.booksIssued = new String[5];
        this.bookCount = 0;
        totalMembers++;
    }

    public static String generateMemberId() {
        return "M" + String.format("%03d", totalMembers + 1);
    }

    public void borrowBook(Book book) {
        if (book.getAvailability() && bookCount < booksIssued.length) {
            book.issueBook();
            booksIssued[bookCount++] = book.getBookId();
        }
    }

    public void returnBook(String bookId, Book[] books) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                for (Book b : books) {
                    if (b.getBookId().equals(bookId)) {
                        b.returnBook();
                        booksIssued[i] = null;
                        break;
                    }
                }
                break;
            }
        }
    }

    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + memberName);
        System.out.print("Books Issued: ");
        for (String id : booksIssued) {
            if (id != null) System.out.print(id + " ");
        }
        System.out.println();
    }
}

public class LP2_library {
    public static void main(String[] args) {
        Book[] books = {
            new Book("The Alchemist", "Paulo Coelho"),
            new Book("1984", "George Orwell"),
            new Book("Clean Code", "Robert C. Martin")
        };

        Member[] members = {
            new Member("Alice"),
            new Member("Bob")
        };

        members[0].borrowBook(books[0]);
        members[1].borrowBook(books[2]);
        members[0].returnBook(books[0].getBookId(), books);

        for (Book b : books) {
            b.displayBookInfo();
            System.out.println();
        }

        for (Member m : members) {
            m.displayMemberInfo();
            System.out.println();
        }

        System.out.println("Total Books: " + Book.getTotalBooks());
        System.out.println("Available Books: " + Book.getAvailableBooks());
    }
}