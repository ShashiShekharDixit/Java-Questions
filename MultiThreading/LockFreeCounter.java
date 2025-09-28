import java.util.concurrent.atomic.AtomicLong;

class CASCounter {
    private final AtomicLong value = new AtomicLong(0);
    public void increment() {
        long prev;
        long next;
        do {
            prev = value.get();
            next = prev + 1;
        } while (!value.compareAndSet(prev, next));
    }
    public long get() {
        return value.get();
    }
}
public class LockFreeCounter {
    public static void main(String[] args) throws InterruptedException {
        CASCounter counter = new CASCounter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Final counter value = " + counter.get());
    }
}
