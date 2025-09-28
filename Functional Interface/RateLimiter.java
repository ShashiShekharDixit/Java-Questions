import java.util.function.Supplier;
public class RateLimiter {
    public static <T> Supplier<T> rateLimit(Supplier<T> supplier, long millisInterval) {
        return new Supplier<>() {
            private long lastCallTime = 0;
            @Override
            public synchronized T get() {
                long now = System.currentTimeMillis();
                if (now - lastCallTime >= millisInterval) {
                    lastCallTime = now;
                    return supplier.get();
                } else {
                    System.out.println("Rate limit exceeded, skipping call");
                    return null; 
                }
            }
        };
    }
    public static void main(String[] args) throws InterruptedException {
        Supplier<String> mySupplier = () -> "Hello at " + System.currentTimeMillis();
        Supplier<String> limitedSupplier = rateLimit(mySupplier, 1000);
        for (int i = 0; i < 5; i++) {
            System.out.println(limitedSupplier.get());
            Thread.sleep(400); 
        }
    }
}
