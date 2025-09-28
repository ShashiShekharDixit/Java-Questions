import java.util.function.Supplier;

public class SupplierRetry {
    public static <T> T retry(Supplier<T> supplier, int maxRetries) {
        int attempts = 0;
        while (true) {
            try {
                return supplier.get(); 
            } catch (Exception e) {
                attempts++;
                if (attempts >= maxRetries) {
                    throw e; 
                }
                System.out.println("Attempt " + attempts + " failed, retrying...");
            }
        }
    }
    public static void main(String[] args) {
        Supplier<Integer> unreliableSupplier = () -> {
            if (Math.random() < 0.7) { 
                throw new RuntimeException("Random failure");
            }
            return 42; 
        };
        try {
            int result = retry(unreliableSupplier, 5);
            System.out.println("Success! Result = " + result);
        } catch (Exception e) {
            System.out.println("All retries failed: " + e.getMessage());
        }
    }
}
