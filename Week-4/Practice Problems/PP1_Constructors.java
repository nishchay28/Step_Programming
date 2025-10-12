public class PP1_Constructors {
    String title;
    String author;
    double price;

    // Default constructor
    public PP1_Constructors() {
        title = "Unknown Title";
        author = "Unknown Author";
        price = 0.0;
    }

    // Parameterized constructor
    public PP1_Constructors(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Display method
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        PP1_Constructors book1 = new PP1_Constructors();
        PP1_Constructors book2 = new PP1_Constructors("The Alchemist", "Paulo Coelho", 499.99);

        book1.display();
        System.out.println();
        book2.display();
    }
}
