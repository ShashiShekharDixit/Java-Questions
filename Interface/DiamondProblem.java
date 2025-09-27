interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
interface B {
    default void hello() {
        System.out.println("Hello from B");
    }
}
class C implements A, B {
    @Override
    public void hello() {
        A.super.hello(); 
        B.super.hello(); 
        System.out.println("Hello from C");
    }
}
public class DiamondProblem {
    public static void main(String[] args) {
        C obj = new C();
        obj.hello();
    }
}
