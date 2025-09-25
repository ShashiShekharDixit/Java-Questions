class BankAccount {
    private String holderName;
    private double balance;
    
    BankAccount(String holderName, double initialBalance) {
        this.holderName = holderName;
        if (initialBalance >= 0) {
            balance = initialBalance;
        } else {
            balance = 0;
        }
    }
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
    void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
    double getBalance() {
        return balance;
    }
    String getHolderName() {
        return holderName;
    }
}
public class BankEncapsulation {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Shashi", 1000);

        System.out.println("Account Holder: " + acc.getHolderName());
        System.out.println("Initial Balance: " + acc.getBalance());

        acc.deposit(500);     
        acc.withdraw(200);    
        acc.withdraw(2000);   

        System.out.println("Final Balance: " + acc.getBalance());
    }
}
