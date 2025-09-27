import java.util.*;
public class PairSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(target - num)) {
                return true; 
            }
            seen.add(num);
        }
        return false; 
    }
    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 1, 5, 3};
        int target = 9;
        if (hasPairWithSum(arr, target)) {
            System.out.println("Array has a pair with sum " + target);
        } else {
            System.out.println("No pair with sum " + target + " found.");
        }
    }
}
