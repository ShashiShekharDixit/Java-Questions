import java.util.function.Supplier;

@FunctionalInterface
interface ThrowingSupplier<T> {
    T get() throws Exception;
}
public class ThrowingSupplierAdapter {
    public static <T> Supplier<T> adapt(ThrowingSupplier<T> ts) {
        return () -> {
            try {
                return ts.get();
            } catch (Exception e) {
                throw new RuntimeException(e); 
            }
        };
    }
    public static void main(String[] args) {
        ThrowingSupplier<String> fileReadSupplier = () -> {
            if (Math.random() < 0.5) throw new java.io.IOException("Failed to read file");
            return "File content";
        };
        Supplier<String> safeSupplier = adapt(fileReadSupplier);
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Attempt " + (i + 1) + ": " + safeSupplier.get());
            } catch (RuntimeException e) {
                System.out.println("Caught exception: " + e.getCause().getMessage());
            }
        }
    }
}
