import java.util.*;
public class ArraySetEquality {
    public static boolean equalAsSets(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        for (int num : a) setA.add(num);
        Set<Integer> setB = new HashSet<>();
        for (int num : b) setB.add(num);
        return setA.equals(setB);
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {4, 3, 1, 2};
        System.out.println("Arrays equal as sets = " + equalAsSets(arr1, arr2));
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {1, 2, 4};
        System.out.println("Arrays equal as sets = " + equalAsSets(arr3, arr4));
    }
}
