import java.util.*;

public class HW2_OnlineCart {
    static class Product {
        String productId, productName, category;
        double price;
        int stockQuantity;
        static int totalProducts = 0;
        static String[] categories = {"Electronics", "Books", "Clothing"};

        Product(String id, String name, double price, String cat, int qty) {
            this.productId = id;
            this.productName = name;
            this.price = price;
            this.category = cat;
            this.stockQuantity = qty;
            totalProducts++;
        }

        static Product findProductById(Product[] products, String id) {
            for (Product p : products) if (p.productId.equals(id)) return p;
            return null;
        }

        static Product[] getProductsByCategory(Product[] products, String cat) {
            return Arrays.stream(products).filter(p -> p.category.equals(cat)).toArray(Product[]::new);
        }
    }

    static class ShoppingCart {
        String cartId, customerName;
        Product[] products = new Product[10];
        int[] quantities = new int[10];
        int count = 0;
        double cartTotal = 0;

        ShoppingCart(String id, String name) {
            this.cartId = id;
            this.customerName = name;
        }

        void addProduct(Product p, int qty) {
            if (p.stockQuantity >= qty) {
                products[count] = p;
                quantities[count] = qty;
                cartTotal += p.price * qty;
                p.stockQuantity -= qty;
                count++;
            }
        }

        void removeProduct(String id) {
            for (int i = 0; i < count; i++) {
                if (products[i].productId.equals(id)) {
                    cartTotal -= products[i].price * quantities[i];
                    products[i].stockQuantity += quantities[i];
                    for (int j = i; j < count - 1; j++) {
                        products[j] = products[j + 1];
                        quantities[j] = quantities[j + 1];
                    }
                    count--;
                    break;
                }
            }
        }

        void displayCart() {
            System.out.println("Cart for " + customerName);
            for (int i = 0; i < count; i++) {
                System.out.println(products[i].productName + " x" + quantities[i]);
            }
            System.out.println("Total: ₹" + cartTotal);
        }

        void checkout() {
            System.out.println("Checked out. Total paid: ₹" + cartTotal);
            cartTotal = 0;
            count = 0;
        }
    }

    public static void main(String[] args) {
        Product[] catalog = {
            new Product("P1", "Laptop", 50000, "Electronics", 5),
            new Product("P2", "Book", 500, "Books", 10),
            new Product("P3", "Shirt", 1000, "Clothing", 8)
        };

        ShoppingCart cart = new ShoppingCart("C1", "NISHCHAY");
        cart.addProduct(catalog[0], 1);
        cart.addProduct(catalog[1], 2);
        cart.displayCart();
        cart.removeProduct("P2");
        cart.displayCart();
        cart.checkout();
    }
}