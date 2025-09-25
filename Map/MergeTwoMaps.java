import java.util.*;
public class MergeTwoMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 3);
        map1.put("banana", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 5);
        map2.put("orange", 4);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            map1.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        System.out.println(map1);
    }
}