import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
interface Notifier {
    void send(String message);
}
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}
class SMSNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}
class PushNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Push notification sent: " + message);
    }
}
class NotifierFactory {
    private static final Map<String, Supplier<Notifier>> notifierMap = new HashMap<>();
    static {
        notifierMap.put("email", EmailNotifier::new);
        notifierMap.put("sms", SMSNotifier::new);
        notifierMap.put("push", PushNotifier::new);
    }
    public static Notifier createNotifier(String type) {
        Supplier<Notifier> supplier = notifierMap.get(type.toLowerCase());
        if (supplier != null) {
            return supplier.get();
        }
        throw new IllegalArgumentException("Unknown notifier type: " + type);
    }
}
public class FactoryMapDemo {
    public static void main(String[] args) {
        Notifier email = NotifierFactory.createNotifier("email");
        email.send("Welcome to our service!");
        Notifier sms = NotifierFactory.createNotifier("sms");
        sms.send("Your OTP is 1234");
        Notifier push = NotifierFactory.createNotifier("push");
        push.send("You have a new message");
    }
}
