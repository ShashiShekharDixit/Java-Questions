import java.util.*;
public class DistinctElementsInWindow {
    public static List<Integer> countDistinctInWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            if (i >= k) {
                int out = arr[i - k];
                freq.put(out, freq.get(out) - 1);
                if (freq.get(out) == 0) {
                    freq.remove(out);
                }
            }
            if (i >= k - 1) {
                result.add(freq.size());
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        List<Integer> distinctCounts = countDistinctInWindow(arr, k);
        System.out.println("Distinct elements in every window of size " + k + ": " + distinctCounts);
    }
}
