import java.util.*;
public class SubarraySumK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); 
        int count = 0;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, -1, 3, 2};
        int k = 3;
        int result = subarraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + " : " + result);
    }
}
