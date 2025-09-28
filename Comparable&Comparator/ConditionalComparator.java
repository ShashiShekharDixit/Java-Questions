import java.time.LocalDateTime;
import java.util.*;
class Task {
    String name;
    LocalDateTime deadline;
    Task(String name, LocalDateTime deadline) {
        this.name = name;
        this.deadline = deadline;
    }
    @Override
    public String toString() {
        return name + " (deadline: " + deadline + ")";
    }
}
public class ConditionalComparator {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Submit report", LocalDateTime.of(2025, 9, 30, 17, 0)));
        tasks.add(new Task("Finish coding", LocalDateTime.of(2025, 9, 30, 12, 0)));
        tasks.add(new Task("Team meeting", LocalDateTime.of(2025, 9, 29, 9, 30)));
        tasks.add(new Task("Client call", LocalDateTime.of(2025, 9, 30, 12, 0)));

        tasks.sort(Comparator.comparing((Task t) -> t.deadline).thenComparing(t -> t.name));
        System.out.println("Tasks ordered by deadline (and name if equal):");
        tasks.forEach(System.out::println);
    }
}
