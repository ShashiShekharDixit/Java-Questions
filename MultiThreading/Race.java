import java.util.concurrent.CountDownLatch;

class Racer implements Runnable {
    private final String name;
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    Racer(String name, CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.name = name;
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }
    @Override
    public void run() {
        try {
            startSignal.await();
            System.out.println(name + " started running!");
            Thread.sleep((long) (Math.random() * 3000) + 1000);
            System.out.println(name + " finished!");
            doneSignal.countDown();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
public class Race {
    public static void main(String[] args) throws InterruptedException {
        int numRacers = 3;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(numRacers);
        for (int i = 1; i <= numRacers; i++) {
            new Thread(new Racer("Racer-" + i, startSignal, doneSignal)).start();
        }
        System.out.println("Get Ready...");
        Thread.sleep(1000);
        System.out.println("Get Set...");
        Thread.sleep(1000);
        System.out.println("Go!");
        startSignal.countDown();
        doneSignal.await();
        System.out.println("Race finished!");
    }
}
