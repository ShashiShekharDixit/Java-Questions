interface Refundable {
    void refund(double amount);
}
abstract class Payment {
    double amount;
    Payment(double amount) {
        this.amount = amount;
    }
    void generateReceipt() {
        System.out.println("Receipt for $" + amount);
    }
    abstract void pay();
}
class CreditCardPayment extends Payment implements Refundable {
    CreditCardPayment(double amount) {
        super(amount);
    }
    @Override
    void pay() {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
    @Override
    public void refund(double amount) {
        System.out.println("Refunded $" + amount + " to Credit Card.");
    }
}
class UPIPayment extends Payment {
    UPIPayment(double amount) {
        super(amount);
    }
    @Override
    void pay() {
        System.out.println("Paid $" + amount + " using UPI.");
    }
}
public class PaymentDemo {
    public static void main(String[] args) {
        Payment credit = new CreditCardPayment(250);
        credit.pay();
        credit.generateReceipt();
        ((Refundable) credit).refund(100);
        Payment upi = new UPIPayment(500);
        upi.pay();
        upi.generateReceipt();
    }
}
