import java.util.*;
public class FirstRepeatingElement {
    public static Integer firstRepeating(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(num)) {
                return num; 
            }
            seen.add(num);
        }
        return null; 
    }
    public static void main(String[] args) {
        int[] arr1 = {2, 5, 1, 2, 3, 5, 1};
        System.out.println("First repeating element: " + firstRepeating(arr1));
        int[] arr2 = {1, 2, 3, 4};
        System.out.println("First repeating element: " + firstRepeating(arr2));
    }
}
