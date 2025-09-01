import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int totalAccounts = 0;

    // Constructor
    public BankAccount(String name, double initialDeposit) {
        this.accountHolderName = name;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    // Static method to generate unique account number
    public static String generateAccountNumber() {
        return "ACC" + String.format("%03d", totalAccounts + 1);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Check balance
    public double checkBalance() {
        return balance;
    }

    // Display account info
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + String.format("%.2f", balance));
    }

    // Static method to get total accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class LP1_BankManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[3];

        // Create 3 accounts
        for (int i = 0; i < accounts.length; i++) {
            System.out.print("Enter name for account " + (i + 1) + ": ");
            String name = sc.nextLine();
            System.out.print("Enter initial deposit: ");
            double deposit = sc.nextDouble();
            sc.nextLine(); // consume newline
            accounts[i] = new BankAccount(name, deposit);
        }

        // Perform transactions
        accounts[0].deposit(500);
        accounts[1].withdraw(200);
        accounts[2].deposit(1000);
        accounts[2].withdraw(300);

        // Display account info
        for (BankAccount acc : accounts) {
            acc.displayAccountInfo();
            System.out.println();
        }

        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());

        sc.close();
    }
}