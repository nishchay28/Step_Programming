import java.util.*;

final class Product {
    private final String productId;
    private final String name;
    private final String category;
    private final String manufacturer;
    private final double basePrice;
    private final double weight;
    private final String[] features;
    private final Map<String, String> specifications;

    private Product(String id, String name, String category, String manufacturer, double price, double weight, String[] features, Map<String, String> specs) {
        this.productId = id;
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.basePrice = price;
        this.weight = weight;
        this.features = features.clone();
        this.specifications = new HashMap<>(specs);
    }

    public static Product createElectronics(String name, String manufacturer) {
        return new Product(UUID.randomUUID().toString(), name, "Electronics", manufacturer, 999.99, 1.5,
                new String[]{"Bluetooth", "WiFi"}, Map.of("Warranty", "2 Years"));
    }

    public static Product createClothing(String name, String manufacturer) {
        return new Product(UUID.randomUUID().toString(), name, "Clothing", manufacturer, 499.0, 0.5,
                new String[]{"Cotton", "Slim Fit"}, Map.of("Size", "M"));
    }

    public static Product createBooks(String name, String manufacturer) {
        return new Product(UUID.randomUUID().toString(), name, "Books", manufacturer, 299.0, 0.3,
                new String[]{"Paperback"}, Map.of("Pages", "300"));
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String[] getFeatures() { return features.clone(); }
    public Map<String, String> getSpecifications() { return new HashMap<>(specifications); }

    public final double calculateTax(String region) {
        return region.equalsIgnoreCase("IN") ? basePrice * 0.18 : basePrice * 0.10;
    }
}

class Customer {
    private final String customerId;
    private final String email;
    private final String accountCreationDate;
    private String name;
    private String phoneNumber;
    private String preferredLanguage;

    public Customer(String id, String email, String date) {
        this.customerId = id;
        this.email = email;
        this.accountCreationDate = date;
    }

    public String getPublicProfile() {
        return "Customer: " + name + ", Language: " + preferredLanguage;
    }

    String getCreditRating() {
        return "A+";
    }
}

class ShoppingCart {
    private final String cartId;
    private final String customerId;
    private final List<Object> items = new ArrayList<>();
    private double totalAmount = 0;
    private int itemCount = 0;

    public ShoppingCart(String cartId, String customerId) {
        this.cartId = cartId;
        this.customerId = customerId;
    }

    public boolean addItem(Object product, int quantity) {
        if (product instanceof Product && quantity > 0) {
            items.add(product);
            itemCount += quantity;
            totalAmount += ((Product) product).calculateTax("IN") * quantity;
            return true;
        }
        return false;
    }

    String getCartSummary() {
        return "Items: " + itemCount + ", Total: ₹" + totalAmount;
    }
}

public class HW2_ECommerceOrder_ImmutableProducts {
    public static void main(String[] args) {
        Product p1 = Product.createElectronics("Smartphone", "TechCorp");
        Product p2 = Product.createBooks("Java Mastery", "EduPress");

        Customer c = new Customer("C001", "nishchay@example.com", "2023-01-01");
        ShoppingCart cart = new ShoppingCart("CART123", c.customerId);

        cart.addItem(p1, 2);
        cart.addItem(p2, 1);

        System.out.println(cart.getCartSummary());
    }
}
