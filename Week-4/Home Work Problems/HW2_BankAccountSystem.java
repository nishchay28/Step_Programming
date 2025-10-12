import java.util.Random;

public class HW2_BankAccountSystem {
    String accountHolder;
    int accountNumber;
    double balance;

    public HW2_BankAccountSystem() {
        accountHolder = "Unknown";
        accountNumber = 0;
        balance = 0.0;
    }

    public HW2_BankAccountSystem(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(900000) + 100000;
        this.balance = 0.0;
    }

    public HW2_BankAccountSystem(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(900000) + 100000;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }

    public static void main(String[] args) {
        HW2_BankAccountSystem acc1 = new HW2_BankAccountSystem();
        HW2_BankAccountSystem acc2 = new HW2_BankAccountSystem("Nishchay");
        HW2_BankAccountSystem acc3 = new HW2_BankAccountSystem("Aarav", 5000.0);

        acc2.deposit(2000);
        acc2.withdraw(500);

        acc3.withdraw(1000);

        acc1.displayAccount();
        System.out.println();
        acc2.displayAccount();
        System.out.println();
        acc3.displayAccount();
    }
}
