public class HW3_OverridingObjectMethods {
    public static void main(String[] args) {
        Book b1 = new Book("1984", "Orwell");
        Book b2 = new Book("1984", "Orwell");
        System.out.println(b1);
        System.out.println("Equal? " + b1.equals(b2));
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book: " + title + " by " + author;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book b = (Book) obj;
            return title.equals(b.title) && author.equals(b.author);
        }
        return false;
    }
}
