import java.util.*;
public class TopK {
    public static void main(String[] args) {
        Map<String, Integer> freq = new HashMap<>();
        freq.put("apple", 10);
        freq.put("banana", 5);
        freq.put("orange", 7);
        freq.put("grape", 12);
        freq.put("kiwi", 6);
        int k = 3;
        PriorityQueue<Map.Entry<String, Integer>> pq =
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll(); 
            }
        }
        List<Map.Entry<String, Integer>> result = new ArrayList<>(pq);
        result.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        System.out.println("Top " + k + " items: " + result);
    }
}
