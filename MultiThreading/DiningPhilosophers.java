import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Philosopher implements Runnable {
    private final int id;
    private final Lock leftFork;
    private final Lock rightFork;
    public Philosopher(int id, Lock leftFork, Lock rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }
    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");
        Thread.sleep((long) (Math.random() * 1000));
    }
    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating.");
        Thread.sleep((long) (Math.random() * 1000));
    }
    @Override
    public void run() {
        try {
            while (true) {
                think();
                if (id % 2 == 0) {
                    rightFork.lock();
                    leftFork.lock();
                } else {
                    leftFork.lock();
                    rightFork.lock();
                }

                eat();

                leftFork.unlock();
                rightFork.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        final int N = 5;
        Lock[] forks = new ReentrantLock[N];
        for (int i = 0; i < N; i++) {
            forks[i] = new ReentrantLock();
        }
        for (int i = 0; i < N; i++) {
            Lock leftFork = forks[i];
            Lock rightFork = forks[(i + 1) % N];
            Thread t = new Thread(new Philosopher(i + 1, leftFork, rightFork));
            t.start();
        }
    }
}
