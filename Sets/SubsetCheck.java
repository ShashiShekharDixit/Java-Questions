import java.util.*;
public class SubsetCheck {
    public static boolean isSubset(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        for (int num : a) setA.add(num);
        Set<Integer> setB = new HashSet<>();
        for (int num : b) setB.add(num);
        return setB.containsAll(setA); 
    }
    public static void main(String[] args) {
        int[] arrA = {1, 2, 3};
        int[] arrB = {3, 2, 1, 4, 5};
        System.out.println("Is A a subset of B = " + isSubset(arrA, arrB));
        int[] arrC = {1, 2, 6};
        int[] arrD = {1, 2, 3, 4};
        System.out.println("Is C a subset of D = " + isSubset(arrC, arrD));
    }
}
