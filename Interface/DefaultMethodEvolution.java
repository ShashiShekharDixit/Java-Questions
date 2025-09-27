interface Logger {
    void log(String message);
    default void logError(String message) {
        log("ERROR: " + message);
    }
}
class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Writing to file: " + message);
    }
    @Override
    public void logError(String message) {
        System.out.println("Writing ERROR to file: " + message);
    }
}
public class DefaultMethodEvolution {
    public static void main(String[] args) {
        Logger console = new ConsoleLogger();
        Logger file = new FileLogger();
        console.log("Normal message");
        console.logError("Something went wrong");
        file.log("Normal message");
        file.logError("Something went wrong");
    }
}
