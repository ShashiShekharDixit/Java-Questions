import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {
    static class SyncCounter {
        private int count = 0;
        public synchronized void increment() {
            count++;
        }
        public synchronized int get() {
            return count;
        }
    }
    static class AtomicCounter {
        private AtomicInteger count = new AtomicInteger(0);
        public void increment() {
            count.incrementAndGet();
        }
        public int get() {
            return count.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int NUM_THREADS = 100;
        final int INCREMENTS = 10000;

        SyncCounter syncCounter = new SyncCounter();
        Thread[] syncThreads = new Thread[NUM_THREADS];

        long syncStart = System.currentTimeMillis();
        for (int i = 0; i < NUM_THREADS; i++) {
            syncThreads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    syncCounter.increment();
                }
            });
            syncThreads[i].start();
        }
        for (Thread t : syncThreads) t.join();
        long syncEnd = System.currentTimeMillis();

        System.out.println("Synchronized Counter: " + syncCounter.get() + " | Time: " + (syncEnd - syncStart) + "ms");

        AtomicCounter atomicCounter = new AtomicCounter();
        Thread[] atomicThreads = new Thread[NUM_THREADS];

        long atomicStart = System.currentTimeMillis();
        for (int i = 0; i < NUM_THREADS; i++) {
            atomicThreads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    atomicCounter.increment();
                }
            });
            atomicThreads[i].start();
        }
        for (Thread t : atomicThreads) t.join();
        long atomicEnd = System.currentTimeMillis();

        System.out.println("AtomicInteger Counter: " + atomicCounter.get() + " | Time: " + (atomicEnd - atomicStart) + "ms");
    }
}
