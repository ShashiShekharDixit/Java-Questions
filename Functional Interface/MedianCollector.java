import java.util.*;
import java.util.stream.Collector;
public class MedianCollector {
    public static Collector<Integer, ?, Double> toMedian() {
        return Collector.of(
            () -> new PriorityQueue<Integer>(Collections.reverseOrder()), 
            (maxHeap, n) -> maxHeap.add(n),
            (max1, max2) -> { max1.addAll(max2); return max1; },
            (maxHeap) -> {
                List<Integer> list = new ArrayList<>(maxHeap);
                Collections.sort(list);
                int size = list.size();
                if (size % 2 == 0) {
                    return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
                } else {
                    return (double) list.get(size / 2);
                }
            }
        );
    }
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        double median = numbers.stream().collect(toMedian());
        System.out.println("Median: " + median);
    }
}
