public class LP1_MethodOverloading {
    public void calculateDelivery(double distance) {
        System.out.println("Basic delivery cost: ₹" + (distance * 5));
    }

    public void calculateDelivery(double distance, int priorityFee) {
        System.out.println("Premium delivery cost: ₹" + (distance * 5 + priorityFee));
    }

    public void calculateDelivery(double distance, int orders, boolean isGroup) {
        double discount = isGroup ? orders * 2 : 0;
        System.out.println("Group delivery cost: ₹" + (distance * 5 - discount));
    }

    public void calculateDelivery(double distance, double discountPercent, double orderAmount) {
        double cost = distance * 5;
        if (orderAmount > 500) {
            cost = 0;
            System.out.println("Festival special: Free delivery!");
        } else {
            cost -= cost * (discountPercent / 100);
            System.out.println("Festival special cost after discount: ₹" + cost);
        }
    }

    public static void main(String[] args) {
        LP1_MethodOverloading app = new LP1_MethodOverloading();
        app.calculateDelivery(10);
        app.calculateDelivery(10, 20);
        app.calculateDelivery(10, 3, true);
        app.calculateDelivery(10, 15, 600);
    }
}
