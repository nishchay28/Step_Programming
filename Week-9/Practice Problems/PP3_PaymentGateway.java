public class Payment {
    public void pay() {
        System.out.println("Generic payment");
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Paid via Credit Card");
    }
}

class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Paid via Wallet");
    }
}

public class PP3_PaymentGateway {
    public static void main(String[] args) {
        Payment[] payments = { new CreditCardPayment(), new WalletPayment() };
        for (Payment p : payments) {
            System.out.println("Class: " + p.getClass().getSimpleName());
            p.pay();
        }
    }
}
