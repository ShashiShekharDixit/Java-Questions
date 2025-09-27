interface Drivable {
    void drive();
}
interface Trackable {
    void trackLocation();
}
class Taxi implements Drivable, Trackable {
    private String id;
    Taxi(String id) {
        this.id = id;
    }
    @Override
    public void drive() {
        System.out.println("Taxi " + id + " is driving.");
    }
    @Override
    public void trackLocation() {
        System.out.println("Taxi " + id + " is at location: 12.9716° N, 77.5946° E");
    }
    public void showId() {
        System.out.println("Taxi ID: " + id);
    }
}
public class TaxiInterface {
    public static void main(String[] args) {
        Taxi taxi = new Taxi("TX1001");
        taxi.drive();
        taxi.trackLocation();
        Drivable d = taxi;
        d.drive();
        Trackable t = taxi;
        t.trackLocation();
    }
}
