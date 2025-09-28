import java.util.concurrent.Semaphore;

class H2O {
    private final Semaphore hSemaphore = new Semaphore(2); 
    private final Semaphore oSemaphore = new Semaphore(0); 
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();       
        releaseHydrogen.run();      
        if (hSemaphore.availablePermits() == 0) {
            oSemaphore.release();   
        }
    }
    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire();       
        releaseOxygen.run();        
        hSemaphore.release(2);      
    }
}
public class H2OPrinter {
    public static void main(String[] args) {
        H2O h2o = new H2O();
        String input = "OOHHHH"; 
        for (char c : input.toCharArray()) {
            if (c == 'H') {
                new Thread(() -> {
                    try {
                        h2o.hydrogen(() -> System.out.print("H"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            } else if (c == 'O') {
                new Thread(() -> {
                    try {
                        h2o.oxygen(() -> System.out.print("O"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            }
        }
    }
}