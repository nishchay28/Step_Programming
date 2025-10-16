import java.util.ArrayList;
import java.util.List;

class Book implements Cloneable {
    String title;

    Book(String title) {
        this.title = title;
    }

    @Override
    protected Book clone() {
        return new Book(this.title);
    }
}

class Library implements Cloneable {
    List<Book> books = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
    }

    // Shallow clone
    protected Library shallowClone() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    // Deep clone
    protected Library deepClone() {
        Library copy = new Library();
        for (Book b : books) {
            copy.addBook(b.clone());
        }
        return copy;
    }
}

public class HW4_DeepVsShallowCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Library lib1 = new Library();
        lib1.addBook(new Book("Java"));
        lib1.addBook(new Book("Python"));

        Library shallow = lib1.shallowClone();
        Library deep = lib1.deepClone();

        shallow.books.get(0).title = "C++";
        deep.books.get(1).title = "Rust";

        System.out.println("Original Library:");
        for (Book b : lib1.books) System.out.println(b.title);

        System.out.println("Shallow Clone:");
        for (Book b : shallow.books) System.out.println(b.title);

        System.out.println("Deep Clone:");
        for (Book b : deep.books) System.out.println(b.title);
    }
}
