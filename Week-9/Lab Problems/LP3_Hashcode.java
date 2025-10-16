class Book {
    int id;
    String title;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
    }
}

public class LP3_Hashcode {
    public static void main(String[] args) {
        Book b1 = new Book(101, "Java");
        Book b2 = new Book(101, "Java");

        System.out.println("Hashcode of b1: " + b1.hashCode());
        System.out.println("Hashcode of b2: " + b2.hashCode());
    }
}
