import java.util.*;
import java.util.stream.Collectors;

public class PartitionList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        java.util.function.Predicate<Integer> isEven = n -> n % 2 == 0;
        Map<Boolean, List<Integer>> partitioned = numbers.stream().collect(Collectors.partitioningBy(isEven));
        System.out.println("Even numbers: " + partitioned.get(true));
        System.out.println("Odd numbers: " + partitioned.get(false));
    }
}
