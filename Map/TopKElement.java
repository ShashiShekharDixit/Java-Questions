import java.util.*;
public class TopKElement {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,4,4,4,4,5};
        int k = 3;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.print("Top " + k + " frequent elements: ");
        for (int i = 0; i < k && i < list.size(); i++) {
            System.out.print(list.get(i).getKey() + " ");
        }
    }
}
