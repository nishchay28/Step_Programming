import java.util.*;

public class HW5_BankAccount {
    static int totalAccounts = 0;
    static String bankName = "SRM Bank";

    static class BankAccount {
        String accountNumber, accountHolderName;
        double balance;
        String[] transactionHistory = new String[10];
        int historyCount = 0;

        BankAccount(String accNo, String name, double initialBalance) {
            this.accountNumber = accNo;
            this.accountHolderName = name;
            this.balance = initialBalance;
            totalAccounts++;
        }

        void deposit(double amount) {
            balance += amount;
            transactionHistory[historyCount++] = "Deposited ₹" + amount;
        }

        void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                transactionHistory[historyCount++] = "Withdrew ₹" + amount;
            }
        }

        void displayAccountSummary() {
            System.out.println("Account: " + accountNumber);
            System.out.println("Holder: " + accountHolderName);
            System.out.println("Balance: ₹" + balance);
        }

        void displayTransactionHistory() {
            System.out.println("Transactions:");
            for (int i = 0; i < historyCount; i++) System.out.println(transactionHistory[i]);
        }

        static void setBankName(String name) {
            bankName = name;
        }

        static int getTotalAccounts() {
            return totalAccounts;
        }
    }

    public static void main(String[] args) {
        BankAccount.setBankName("SRM Bank");
        BankAccount b1 = new BankAccount("A001", "NISHCHAY", 10000);
        b1.deposit(5000);
        b1.withdraw(3000);
        b1.displayAccountSummary();
        b1.displayTransactionHistory();
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
