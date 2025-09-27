interface PaymentGateway {
    boolean pay(double amount);
}
class StripeGateway implements PaymentGateway {
    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " via Stripe.");
        return true;
    }
}
class MockGateway implements PaymentGateway {
    @Override
    public boolean pay(double amount) {
        System.out.println("Mock payment of " + amount);
        return true;
    }
}
class PaymentService {
    private final PaymentGateway gateway;
    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway; 
    }
    public void processPayment(double amount) {
        if (gateway.pay(amount)) {
            System.out.println("Payment processed successfully.");
        } else {
            System.out.println("Payment failed!");
        }
    }
}
public class InterfaceDI {
    public static void main(String[] args) {
        PaymentService service = new PaymentService(new StripeGateway());
        service.processPayment(100);
        System.out.println("-> Testing with mock <-");
        PaymentService testService = new PaymentService(new MockGateway());
        testService.processPayment(50);
    }
}
