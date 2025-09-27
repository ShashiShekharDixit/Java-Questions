import java.util.*;
import java.util.stream.*;
public class MapSortByValue {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Shashi", 90);
        scores.put("Shekhar", 95);
        scores.put("Saurabh", 90);
        scores.put("Sachin", 85);
        LinkedHashMap<String, Integer> sortedMap = scores.entrySet()
            .stream()
            .sorted(
                Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.comparingByKey())
            )
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1, 
                LinkedHashMap::new 
            ));
        System.out.println("Sorted map: " + sortedMap);
    }
}
