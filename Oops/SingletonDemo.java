class Singleton {
    private Singleton() {
        System.out.println("Singleton instance created");
    }
    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        s1.showMessage();
        if (s1 == s2) {
            System.out.println("Both references point to the same instance.");
        }
    }
}
