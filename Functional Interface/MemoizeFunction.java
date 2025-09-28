import java.util.*;
import java.util.function.Function;

public class MemoizeFunction {
    public static <T, R> Function<T, R> memoize(Function<T, R> func) {
        Map<T, R> cache = new HashMap<>();
        return input -> cache.computeIfAbsent(input, func);
    }
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Function<Integer, Integer> memoFib = memoize(MemoizeFunction::fib);
        System.out.println("Fib(10) = " + memoFib.apply(10));
        System.out.println("Fib(15) = " + memoFib.apply(15));
        System.out.println("Fib(10) again = " + memoFib.apply(10)); 
    }
}
