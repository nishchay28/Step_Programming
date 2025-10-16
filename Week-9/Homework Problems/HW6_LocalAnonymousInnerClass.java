interface Discount {
    void apply();
}

class Payment {
    void processTransaction(double amount) {
        class Validator {
            boolean isValid() {
                return amount > 0;
            }
        }

        Validator v = new Validator();
        if (v.isValid()) {
            System.out.println("Valid payment of ₹" + amount);
        } else {
            System.out.println("Invalid payment amount.");
        }

        Discount d = new Discount() {
            public void apply() {
                System.out.println("Discount applied: ₹50 off");
            }
        };
        d.apply();
    }
}

public class HW6_LocalAnonymousInnerClass {
    public static void main(String[] args) {
        Payment p = new Payment();
        p.processTransaction(500);
    }
}
