import java.util.concurrent.*;

public class TimeoutCancellation {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Task running step " + i);
                    Thread.sleep(100); 
                }
                return "Task completed!";
            } catch (InterruptedException e) {
                System.out.println("Task interrupted!");
                throw e;
            }
        });
        try {
            String result = future.get(3, TimeUnit.SECONDS);
            System.out.println("Result: " + result);
        } catch (TimeoutException e) {
            System.out.println("Timeout reached! Cancelling the task...");
            future.cancel(true); 
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
