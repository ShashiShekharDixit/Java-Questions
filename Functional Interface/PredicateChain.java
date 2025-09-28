import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateChain {
    public static void main(String[] args) {
        List<String> inputs = Arrays.asList("12", "abc", "1234", "7", "0", "abcd");
        Predicate<String> pNumeric = s -> s.matches("\\d+");
        Predicate<String> pLen = s -> s.length() <= 3;
        Predicate<String> combined = pNumeric.and(pLen);
        List<String> result = inputs.stream().filter(combined).collect(Collectors.toList());

        System.out.println("Strings that are numeric and length ≤ 3: " + result);
    }
}
