import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(double price);
}
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
class PriceTicker implements Subject {
    private double price;
    private List<Observer> observers = new ArrayList<>();
    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
    public double getPrice() {
        return price;
    }
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}
class ConsoleView implements Observer {
    private String name;
    ConsoleView(String name) {
        this.name = name;
    }
    @Override
    public void update(double price) {
        System.out.println(name + " sees price update: " + price);
    }
}
public class ObserverDemo {
    public static void main(String[] args) {
        PriceTicker ticker = new PriceTicker();
        ConsoleView view1 = new ConsoleView("View1");
        ConsoleView view2 = new ConsoleView("View2");
        ticker.addObserver(view1);
        ticker.addObserver(view2);
        ticker.setPrice(100.0);
        ticker.setPrice(105.5);
        ticker.setPrice(102.75);
        ticker.removeObserver(view1);
        ticker.setPrice(110.0);
    }
}
