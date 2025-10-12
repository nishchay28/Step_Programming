public class HW1_PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    static int  totalAccounts;
    static String bankName;

    public HW1_PersonalAccount(String name){
        this.accountHolderName = name;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }

    public void addIncome(double amount ,String description ){
        totalIncome += amount;
        currentBalance += amount;
    }

    public void addExpense(double amount , String description ){
        totalExpenses += amount;
        currentBalance -= amount;
    }

    public double calculateSavings(){
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary(){
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder Name: "+ accountHolderName);
        System.out.println("Account Number: "+ accountNumber);
        System.out.println("Current Balance: "+ currentBalance);
        System.out.println("Total Income: "+ totalIncome);
        System.out.println("Total Expensess: "+ totalExpenses);
        System.out.println("Total Saving: "+ calculateSavings());
        System.out.println("Total Accounts: "+ getTotalAccount());
    }

    public static void setBankName(String name){
        bankName = name;
    }
    
    public static int getTotalAccount(){
        return totalAccounts;
    }

    public static String generateAccountNumber(){
        return "ACCT" + (1000+totalAccounts);
    }

    // ---------------- MAIN METHOD INSIDE ----------------
    public static void main(String[] args) {
        HW1_PersonalAccount.setBankName("HDFC");

        HW1_PersonalAccount acc1 = new HW1_PersonalAccount("Nishu");
        acc1.addIncome(5000, "Salary");
        acc1.addExpense(1000,"Rent");

        HW1_PersonalAccount acc2 = new HW1_PersonalAccount("Alice");
        acc2.addIncome(7000, "Freelance");
        acc2.addExpense(2500, "Travel");

        HW1_PersonalAccount acc3 = new HW1_PersonalAccount("Happy");
        acc3.addIncome(6000, "Business");
        acc3.addExpense(1800, "Supplies");

        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();

        System.out.println("Total Accounts: " + HW1_PersonalAccount.getTotalAccount());
    }
}
