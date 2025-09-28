import java.util.concurrent.*;

public class CompletableFuturePipeline {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching number 1...");
            return 20;
        }, executor);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching number 2...");
            return 30;
        }, executor);
        CompletableFuture<Integer> squared1 = future1.thenApply(x -> {
            System.out.println("Squaring first number...");
            return x * x;
        });
        CompletableFuture<Integer> squared2 = future2.thenApply(x -> {
            System.out.println("Squaring second number...");
            return x * x;
        });
        CompletableFuture<Integer> combined = squared1.thenCombine(squared2, (a, b) -> {
            System.out.println("Combining results...");
            return a + b;
        });
        CompletableFuture<Integer> safeResult = combined.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex);
            return -1;
        });
        System.out.println("Final result = " + safeResult.get());
        executor.shutdown();
    }
}
