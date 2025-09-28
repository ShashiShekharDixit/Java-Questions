import java.util.concurrent.*;

public class BoundedThreadPool {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maxPoolSize = 2;
        int queueCapacity = 3;
        RejectedExecutionHandler handler = (r, executor) -> {
            System.out.println("Task rejected: " + r.toString() + " - applying backpressure...");
            try {
                executor.getQueue().put(r);
                System.out.println("Task enqueued after backpressure: " + r.toString());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,maxPoolSize,60,TimeUnit.SECONDS,new ArrayBlockingQueue<>(queueCapacity),handler);
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing task " + taskId + " by " + Thread.currentThread().getName());
                try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("All tasks completed.");
    }
}
