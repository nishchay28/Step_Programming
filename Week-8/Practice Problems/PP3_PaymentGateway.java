interface PaymentGateway {
    void pay(double amount);
    void refund(double amount);
}

class CreditCardPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund ₹" + amount + " to Credit Card");
    }
}

class UPIPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund ₹" + amount + " to UPI");
    }
}

public class PP3_PaymentGateway {
    public static void main(String[] args) {
        PaymentGateway pg1 = new CreditCardPayment();
        pg1.pay(1500);
        pg1.refund(500);

        PaymentGateway pg2 = new UPIPayment();
        pg2.pay(800);
        pg2.refund(300);
    }
}
