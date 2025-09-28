import java.util.concurrent.*;
public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        int NUM_CONSUMERS = 3;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_CONSUMERS + 1);
        executor.submit(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(100); 
                }
                for (int i = 0; i < NUM_CONSUMERS; i++) {
                    queue.put(-1);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        for (int c = 1; c <= NUM_CONSUMERS; c++) {
            final int id = c;
            executor.submit(() -> {
                try {
                    while (true) {
                        int item = queue.take();
                        if (item == -1) {
                            System.out.println("Consumer " + id + " received sentinel. Exiting...");
                            break;
                        }
                        System.out.println("Consumer " + id + " consumed: " + item);
                        Thread.sleep(200); 
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}