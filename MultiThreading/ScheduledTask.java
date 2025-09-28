import java.util.concurrent.*;

public class ScheduledTask {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Task executed at: " + java.time.LocalTime.now());
        }, 0, 1, TimeUnit.SECONDS);
        Thread.sleep(5000);
        System.out.println("Cancelling task...");
        future.cancel(true);
        scheduler.shutdown();
        System.out.println("Scheduler shutdown.");
    }
}
