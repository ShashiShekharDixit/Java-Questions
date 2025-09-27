import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 3, 2, 5, 1, 2, 4);
        Set<Integer> linkedSet = new LinkedHashSet<>(numbers);
        List<Integer> uniqueList1 = new ArrayList<>(linkedSet);
        System.out.println("Unique list (LinkedHashSet): " + uniqueList1);
        List<Integer> uniqueList2 = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (Integer num : numbers) {
            if (seen.add(num)) { 
                uniqueList2.add(num);
            }
        }
        System.out.println("Unique list (manual): " + uniqueList2);
    }
}