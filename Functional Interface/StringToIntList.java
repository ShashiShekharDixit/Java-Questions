import java.util.*;
import java.util.stream.Collectors;

public class StringToIntList {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("1", "2", "3", "10", "20");
        List<Integer> intList1 = strList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        List<Integer> intList2 = strList.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Converted with lambda: " + intList1);
        System.out.println("Converted with method reference: " + intList2);
    }
}
