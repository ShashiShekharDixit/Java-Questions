import java.util.*;
public class HappyNumber {
    private static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }
        return n == 1;
    }
    public static void main(String[] args) {
        int num = 19;
        if (isHappy(num)) {
            System.out.println(num + " is a Happy Number!");
        } else {
            System.out.println(num + " is NOT a Happy Number.");
        }
    }
}
