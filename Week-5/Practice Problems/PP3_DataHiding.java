public class PP3_DataHiding {
    private final String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public PP3_DataHiding(String accNo, double initialBalance) {
        accountNumber = accNo;
        balance = Math.max(initialBalance, MIN_BALANCE);
        pin = 0;
        isLocked = false;
        failedAttempts = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return isLocked ? -1 : balance;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    public void setPin(int newPin) {
        pin = newPin;
    }

    public void attemptAccess(int enteredPin) {
        if (isLocked) {
            System.out.println("Account is locked.");
            return;
        }
        if (enteredPin == pin) {
            System.out.println("Access granted.");
            failedAttempts = 0;
        } else {
            failedAttempts++;
            System.out.println("Incorrect PIN.");
            if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
                isLocked = true;
                System.out.println("Account locked due to multiple failed attempts.");
            }
        }
    }

    public static void main(String[] args) {
        PP3_DataHiding acc = new PP3_DataHiding("SBIN123456", 5000);
        acc.setPin(1234);
        acc.attemptAccess(1111);
        acc.attemptAccess(2222);
        acc.attemptAccess(1234);
        System.out.println("Balance: ₹" + acc.getBalance());
    }
}
