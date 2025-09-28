import java.util.concurrent.*;

public class BulkheadIsolation {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService domainA = Executors.newFixedThreadPool(2);
        ExecutorService domainB = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            domainA.submit(() -> {
                System.out.println("Domain A - Task " + taskId + " started by " + Thread.currentThread().getName());
                try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                System.out.println("Domain A - Task " + taskId + " finished by " + Thread.currentThread().getName());
            });
        }
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            domainB.submit(() -> {
                System.out.println("Domain B - Task " + taskId + " started by " + Thread.currentThread().getName());
                try { Thread.sleep(1500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                System.out.println("Domain B - Task " + taskId + " finished by " + Thread.currentThread().getName());
            });
        }
        domainA.shutdown();
        domainB.shutdown();
        domainA.awaitTermination(10, TimeUnit.SECONDS);
        domainB.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("All tasks completed.");
    }
}
