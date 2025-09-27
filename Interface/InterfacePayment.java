interface Payable {
    void pay(double amount);
}
interface Refundable {
    void refund(double amount);
}
interface Reconcilable {
    void reconcile();
}
class CreditCardPayment implements Payable, Refundable, Reconcilable {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card.");
    }
    @Override
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " to Credit Card.");
    }
    @Override
    public void reconcile() {
        System.out.println("Reconciling Credit Card transactions...");
    }
}
class GiftCardPayment implements Payable {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Gift Card.");
    }
}
class BankTransferPayment implements Payable, Reconcilable {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Bank Transfer.");
    }
    @Override
    public void reconcile() {
        System.out.println("Reconciling Bank Transfer transactions...");
    }
}
public class InterfacePayment {
    public static void main(String[] args) {
        Payable credit = new CreditCardPayment();
        Payable gift = new GiftCardPayment();
        Payable bank = new BankTransferPayment();
        credit.pay(100);
        gift.pay(50);
        bank.pay(200);
        Refundable refundable = new CreditCardPayment();
        refundable.refund(30);
        Reconcilable recon1 = new CreditCardPayment();
        Reconcilable recon2 = new BankTransferPayment();
        recon1.reconcile();
        recon2.reconcile();
    }
}