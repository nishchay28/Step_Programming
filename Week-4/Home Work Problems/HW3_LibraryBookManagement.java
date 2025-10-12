public class HW3_LibraryBookManagement {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    public HW3_LibraryBookManagement() {
        title = "";
        author = "";
        isbn = "";
        isAvailable = true;
    }

    public HW3_LibraryBookManagement(String title, String author) {
        this.title = title;
        this.author = author;
        this.isbn = "";
        this.isAvailable = true;
    }

    public HW3_LibraryBookManagement(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        HW3_LibraryBookManagement b1 = new HW3_LibraryBookManagement();
        HW3_LibraryBookManagement b2 = new HW3_LibraryBookManagement("1984", "George Orwell");
        HW3_LibraryBookManagement b3 = new HW3_LibraryBookManagement("Brave New World", "Aldous Huxley", "9780060850524", true);

        b2.borrowBook();
        b3.borrowBook();
        b3.returnBook();

        b1.displayBookInfo();
        System.out.println();
        b2.displayBookInfo();
        System.out.println();
        b3.displayBookInfo();
    }
}
