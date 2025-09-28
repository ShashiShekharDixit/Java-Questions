import java.util.concurrent.locks.ReentrantReadWriteLock;
class SharedData {
    private int value = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read(String readerName) {
        lock.readLock().lock();
        try {
            System.out.println(readerName + " is Reading value: " + value);
            try { Thread.sleep(200); } catch (InterruptedException ignored) {}
        } finally {
            System.out.println(readerName + " finished Reading.");
            lock.readLock().unlock();
        }
    }
    public void write(String writerName, int newValue) {
        lock.writeLock().lock();
        try {
            System.out.println(writerName + " is Writing new value: " + newValue);
            value = newValue;
            try { Thread.sleep(300); } catch (InterruptedException ignored) {}
        } finally {
            System.out.println(writerName + " finished Writing.");
            lock.writeLock().unlock();
        }
    }
}
public class ReadersWriters {
    public static void main(String[] args) {
        SharedData data = new SharedData();
        for (int i = 1; i <= 3; i++) {
            final String readerName = "Reader-" + i;
            new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    data.read(readerName);
                }
            }).start();
        }
        for (int i = 1; i <= 2; i++) {
            final String writerName = "Writer-" + i;
            final int newValue = i * 10;
            new Thread(() -> {
                for (int j = 0; j < 2; j++) {
                    data.write(writerName, newValue + j);
                }
            }).start();
        }
    }
}
