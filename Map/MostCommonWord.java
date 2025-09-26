import java.util.*;
public class MostCommonWord {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog. The dog was not amused.";
        Set<String> stopwords = new HashSet<>(Arrays.asList(
            "the", "over", "was", "not", "a", "an", "and", "or", "to", "of", "in", "on"
        ));
        String[] words = text.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            if (!stopwords.contains(word)) {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }
        }
        String mostCommon = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }
        System.out.println("Most common word (excluding stopwords): " + mostCommon);
        System.out.println("Count: " + maxCount);
    }
}
