public class HW1_HotelBookingSystem {
    public void bookRoom(String type, int nights) {
        System.out.println("Standard booking: ₹" + (nights * getRate(type)));
    }

    public void bookRoom(String type, int nights, double seasonalMultiplier) {
        System.out.println("Seasonal booking: ₹" + (nights * getRate(type) * seasonalMultiplier));
    }

    public void bookRoom(String type, int nights, double discount, boolean mealPackage) {
        double base = nights * getRate(type);
        base -= discount;
        if (mealPackage) base += 500;
        System.out.println("Corporate booking: ₹" + base);
    }

    public void bookRoom(String type, int nights, int guests, int decorationFee, boolean catering) {
        double base = nights * getRate(type);
        base += guests * 100 + decorationFee;
        if (catering) base += 1000;
        System.out.println("Wedding package: ₹" + base);
    }

    private int getRate(String type) {
        return switch (type) {
            case "Deluxe" -> 2000;
            case "Suite" -> 3500;
            default -> 1500;
        };
    }

    public static void main(String[] args) {
        HW1_HotelBookingSystem h = new HW1_HotelBookingSystem();
        h.bookRoom("Deluxe", 3);
        h.bookRoom("Suite", 2, 1.2);
        h.bookRoom("Deluxe", 4, 500, true);
        h.bookRoom("Suite", 2, 100, 300, true);
    }
}
