import java.util.Arrays;
import java.util.List;

public class StreamReduceConcat {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        String resultReduce = words.stream().reduce((a, b) -> a + "," + b).orElse("");  
        System.out.println("Concatenated with reduce: " + resultReduce);
        String resultJoin = words.stream().collect(java.util.stream.Collectors.joining(","));
        System.out.println("Concatenated with joining: " + resultJoin);
    }
}
