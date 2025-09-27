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
public class TaskSorter {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Submit report", LocalDateTime.of(2025, 10, 1, 17, 0)));
        tasks.add(new Task("Finish coding", LocalDateTime.of(2025, 9, 29, 12, 0)));
        tasks.add(new Task("Team meeting", LocalDateTime.of(2025, 9, 28, 9, 30)));
        tasks.sort(Comparator.comparing(t -> t.deadline));
        System.out.println("Tasks ordered by deadline:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
