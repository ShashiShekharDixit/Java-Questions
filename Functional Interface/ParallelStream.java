import java.util.*;
import java.util.stream.Collectors;

public class ParallelStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> unsafeList = Collections.synchronizedList(new ArrayList<>());
        numbers.parallelStream().forEach(n -> unsafeList.add(n * 2));
        System.out.println("UnsafeList (might work, but needs sync): " + unsafeList);
        List<Integer> safeList = numbers.parallelStream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println("SafeList (thread-safe): " + safeList);
        StringBuilder sb = new StringBuilder();
        numbers.parallelStream().forEach(n -> sb.append(n)); 
        System.out.println("StringBuilder (race condition possible): " + sb);
    }
}
