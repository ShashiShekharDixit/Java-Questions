interface Notifier {
    void send(String message);
}
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappee;
    public NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }
    @Override
    public void send(String message) {
        wrappee.send(message); 
    }
}
class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier wrappee) {
        super(wrappee);
    }
    @Override
    public void send(String message) {
        super.send(message); 
        System.out.println("Sending SMS: " + message);
    }
}
class SlackNotifier extends NotifierDecorator {
    public SlackNotifier(Notifier wrappee) {
        super(wrappee);
    }
    @Override
    public void send(String message) {
        super.send(message); 
        System.out.println("Sending Slack: " + message);
    }
}
public class Decorator {
    public static void main(String[] args) {
        Notifier email = new EmailNotifier();
        Notifier emailAndSMS = new SMSNotifier(email);
        Notifier allChannels = new SlackNotifier(emailAndSMS);
        System.out.println("-> Only Email <-");
        email.send("Hello World!");
        System.out.println("\n-> Email + SMS <-");
        emailAndSMS.send("Hello World!");
        System.out.println("\n-> Email + SMS + Slack <-");
        allChannels.send("Hello World!");
    }
}
