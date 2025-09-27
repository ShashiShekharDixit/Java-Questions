import java.util.*;

public class SortStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "bat", "banana", "cat", "apricot", "dog");
        words.sort(
            Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()) 
        );
        System.out.println("Sorted strings: " + words);
    }
}
