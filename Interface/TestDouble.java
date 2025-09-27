interface PaymentGateway {
    boolean pay(double amount);
}
class StripeGateway implements PaymentGateway {
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing real payment: " + amount);
        return true; 
    }
}
class PaymentService {
    private final PaymentGateway gateway;
    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }
    public boolean makePayment(double amount) {
        return gateway.pay(amount);
    }
}
class MockGateway implements PaymentGateway {
    private boolean called = false;
    @Override
    public boolean pay(double amount) {
        called = true;
        System.out.println("Mock payment of " + amount);
        return true;
    }
    public boolean wasCalled() {
        return called;
    }
}
public class TestDouble {
    public static void main(String[] args) {
        PaymentService realService = new PaymentService(new StripeGateway());
        System.out.println("Real payment result: " + realService.makePayment(100));
        System.out.println("-> Using Mock for test <-");
        MockGateway mock = new MockGateway();
        PaymentService testService = new PaymentService(mock);
        boolean result = testService.makePayment(50);
        System.out.println("Test payment result: " + result);
        System.out.println("Was mock called? " + mock.wasCalled());
    }
}
