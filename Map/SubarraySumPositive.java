public class SubarraySumPositive {
    public static int countSubarraysWithSum(int[] nums, int target) {
        int count = 0;
        int left = 0;
        int currentSum = 0;
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            if (currentSum == target) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2};
        int target = 3;
        int result = countSubarraysWithSum(nums, target);
        System.out.println("Number of subarrays with sum " + target + " : " + result);
    }
}
