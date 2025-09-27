import java.util.*;
import java.time.LocalDate;
class Order {
    String id;
    LocalDate date;
    int priority;
    Order(String id, LocalDate date, int priority) {
        this.id = id;
        this.date = date;
        this.priority = priority;
    }
    @Override
    public String toString() {
        return String.format("Order{id='%s', date=%s, priority=%d}", id, date, priority);
    }
}
public class OrderPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Order> pq = new PriorityQueue<>(
            Comparator.comparing((Order o) -> o.date).thenComparingInt(o -> o.priority) 
        );
        pq.add(new Order("A1", LocalDate.of(2025, 9, 28), 2));
        pq.add(new Order("A2", LocalDate.of(2025, 9, 27), 1));
        pq.add(new Order("A3", LocalDate.of(2025, 9, 27), 3));
        pq.add(new Order("A4", LocalDate.of(2025, 9, 28), 1));
        System.out.println("Orders polled in priority order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
