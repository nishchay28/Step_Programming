public class HW4_FoodDeliveryOrder {
    String customerName;
    String foodItem;
    int quantity;
    double price;

    public HW4_FoodDeliveryOrder() {
        customerName = "Unknown";
        foodItem = "Unknown";
        quantity = 0;
        price = 0.0;
    }

    public HW4_FoodDeliveryOrder(String foodItem) {
        this.customerName = "Guest";
        this.foodItem = foodItem;
        this.quantity = 1;
        this.price = 100.0;
    }

    public HW4_FoodDeliveryOrder(String foodItem, int quantity) {
        this.customerName = "Guest";
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * 100.0;
    }

    public void printBill() {
        System.out.println("Customer: " + customerName);
        System.out.println("Food Item: " + foodItem);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: ₹" + price);
    }

    public static void main(String[] args) {
        HW4_FoodDeliveryOrder o1 = new HW4_FoodDeliveryOrder();
        HW4_FoodDeliveryOrder o2 = new HW4_FoodDeliveryOrder("Burger");
        HW4_FoodDeliveryOrder o3 = new HW4_FoodDeliveryOrder("Pizza", 3);

        o1.printBill();
        System.out.println();
        o2.printBill();
        System.out.println();
        o3.printBill();
    }
}
