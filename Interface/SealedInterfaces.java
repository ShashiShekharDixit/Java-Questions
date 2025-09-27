sealed interface Expr permits Num, Sum { }
final class Num implements Expr {
    final int value;
    Num(int value) { this.value = value; }
}
final class Sum implements Expr {
    final Expr left, right;
    Sum(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }
}
public class SealedInterfaces {
    static int eval(Expr expr) {
        return switch(expr) {
            case Num n -> n.value;
            case Sum s -> eval(s.left) + eval(s.right);
        };
    }
    public static void main(String[] args) {
        Expr expr = new Sum(new Num(5), new Sum(new Num(3), new Num(2)));
        System.out.println("Result: " + eval(expr));
    }
}
