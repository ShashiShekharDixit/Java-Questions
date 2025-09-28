import java.util.concurrent.*;

public class SemaphoreRateLimiter {
    public static void main(String[] args) throws InterruptedException {
        int maxPermits = 3; 
        Semaphore semaphore = new Semaphore(maxPermits);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    semaphore.acquire(); 
                    System.out.println("Task " + taskId + " is running by " + Thread.currentThread().getName());
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    System.out.println("Task " + taskId + " finished.");
                    semaphore.release(); 
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(15, TimeUnit.SECONDS);
        System.out.println("All tasks completed.");
    }
}
