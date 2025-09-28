import java.util.*;
class FixedComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        int cmp = Integer.compare(a % 2, b % 2);
        if (cmp != 0) return cmp; 
        return Integer.compare(a, b);
    }
}
public class FixedTransitivity {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 3, 4, 1, 5, 6);
        Collections.sort(nums, new FixedComparator());
        System.out.println("Sorted list: " + nums);
    }
}
