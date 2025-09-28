import java.util.function.BiFunction;
import java.util.function.Function;

public class CurryBiFunction {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function<Integer, Function<Integer, Integer>> curriedSum = 
            a -> b -> sum.apply(a, b);
        Function<Integer, Integer> add5 = curriedSum.apply(5);
        System.out.println("5 + 10 = " + add5.apply(10));
        System.out.println("5 + 20 = " + add5.apply(20));
        int result = curriedSum.apply(7).apply(3);
        System.out.println("7 + 3 = " + result);
    }
}
