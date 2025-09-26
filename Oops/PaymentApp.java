import java.util.ArrayList;
import java.util.List;

interface PaymentMethod {
    void pay(double amount);
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with Credit Card");
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with PayPal");
    }
}

class PaymentProcessor {
    private List<PaymentMethod> payments = new ArrayList<>();

    public void addPayment(PaymentMethod payment) {
        payments.add(payment);
    }

    public void processPayments(double amount) {
        for (PaymentMethod payment : payments) {
            payment.pay(amount);
        }
    }
}

class Logger {
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

public class PaymentApp {
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.log("Starting Payment App...");
        PaymentProcessor processor = new PaymentProcessor();
        processor.addPayment(new CreditCardPayment());
        processor.addPayment(new PayPalPayment());
        processor.processPayments(250.0);
        logger.log("Payments completed successfully.");
    }
}
