class Printer {
    private final Object lock = new Object();
    private boolean isOddTurn = true;
    public void printOdd(int n) throws InterruptedException {
        synchronized (lock) {
            while (!isOddTurn) {
                lock.wait();
            }
            System.out.println("odd: " + n);
            isOddTurn = false;
            lock.notify();
        }
    }
    public void printEven(int n) throws InterruptedException {
        synchronized (lock) {
            while (isOddTurn) {
                lock.wait();
            }
            System.out.println("even: " + n);
            isOddTurn = true;
            lock.notify();
        }
    }
}
public class OddEvenPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 100; i += 2) {
                try {
                    printer.printOdd(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 100; i += 2) {
                try {
                    printer.printEven(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        oddThread.start();
        evenThread.start();
    }
}