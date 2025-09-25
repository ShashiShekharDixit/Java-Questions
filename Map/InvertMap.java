import java.util.*;
public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 1);
        map.put("grapes", 3);

        Map<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        System.out.println("Original map: " + map);
        System.out.println("Inverted map: " + inverted);
    }
}