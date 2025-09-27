interface Special { }  
class NormalClass {
    public void process() {
        System.out.println("Processing normally...");
    }
}
class SpecialClass implements Special {
    public void process() {
        System.out.println("Processing with special privileges!");
    }
}
public class MarkerInterface {
    public static void main(String[] args) {
        Object obj1 = new NormalClass();
        Object obj2 = new SpecialClass();
        handleObject(obj1);
        handleObject(obj2);
    }
    static void handleObject(Object obj) {
        if (obj instanceof Special) {
            System.out.println("-> Detected Special Marker <-");
            ((SpecialClass) obj).process();
        } else {
            System.out.println("-> Normal Object <-");
            ((NormalClass) obj).process();
        }
    }
}
