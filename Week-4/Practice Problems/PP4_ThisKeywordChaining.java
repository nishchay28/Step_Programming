public class PP4_ThisKeywordChaining {
    String brand;
    String processor;
    int ram;
    double price;

    public PP4_ThisKeywordChaining() {
        this("Unknown", "i3", 4, 30000.0);
    }

    public PP4_ThisKeywordChaining(String brand, String processor) {
        this(brand, processor, 8, 45000.0);
    }

    public PP4_ThisKeywordChaining(String brand, String processor, int ram, double price) {
        this.brand = brand;
        this.processor = processor;
        this.ram = ram;
        this.price = price;
    }

    public void displaySpecs() {
        System.out.println("Brand: " + brand);
        System.out.println("Processor: " + processor);
        System.out.println("RAM: " + ram + "GB");
        System.out.println("Price: ₹" + price);
    }

    public static void main(String[] args) {
        PP4_ThisKeywordChaining l1 = new PP4_ThisKeywordChaining();
        PP4_ThisKeywordChaining l2 = new PP4_ThisKeywordChaining("Dell", "i5");
        PP4_ThisKeywordChaining l3 = new PP4_ThisKeywordChaining("HP", "i7", 16, 75000.0);

        l1.displaySpecs();
        System.out.println();
        l2.displaySpecs();
        System.out.println();
        l3.displaySpecs();
    }
}
