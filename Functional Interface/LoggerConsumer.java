import java.util.function.Consumer;
import java.time.LocalDateTime;

public class LoggerConsumer {
    public static void main(String[] args) {
        Consumer<String> printMessage = msg -> System.out.println("Message: " + msg);
        Consumer<String> loggerConsumer = msg -> {
            System.out.println("[" + LocalDateTime.now() + "] Starting consumption");
            printMessage.accept(msg);
            System.out.println("[" + LocalDateTime.now() + "] Finished consumption");
        };
        loggerConsumer.accept("Hello, world!");
        loggerConsumer.accept("Functional programming in Java");
    }
}
