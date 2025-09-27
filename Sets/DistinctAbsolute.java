import java.util.*;
public class DistinctAbsolute {
    public static int countDistinctAbsolute(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int count = 0;
        int last = Integer.MIN_VALUE;
        while (left <= right) {
            int absLeft = Math.abs(arr[left]);
            int absRight = Math.abs(arr[right]);
            int maxAbs = Math.max(absLeft, absRight);
            if (maxAbs != last) {
                count++;
                last = maxAbs;
            }
            if (absLeft >= absRight) {
                left++;
            } 
            if (absRight >= absLeft) {
                right--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {-3, -2, -2, 0, 1, 2, 3, 3};
        System.out.println("Distinct absolute values: " + countDistinctAbsolute(arr));
    }
}
