import java.util.*;
public class PowerSet {
    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private static void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backtrack(nums, index + 1, current, result);
        current.remove(current.size() - 1); 
        backtrack(nums, index + 1, current, result);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = powerSet(nums);
        System.out.println("Power set: " + subsets);
    }
}
