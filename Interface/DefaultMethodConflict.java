interface InterfaceA {
    default void hello() {
        System.out.println("Hello from InterfaceA");
    }
}
interface InterfaceB {
    default void hello() {
        System.out.println("Hello from InterfaceB");
    }
}
class MyClass implements InterfaceA, InterfaceB {
    @Override
    public void hello() {
        System.out.println("Hello from MyClass");
        InterfaceA.super.hello();
        InterfaceB.super.hello();
    }
}
public class DefaultMethodConflict {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.hello();
    }
}
