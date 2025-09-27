import java.util.*;
public class BigramFrequency {
    public static void main(String[] args) {
        String text = "the quick brown fox jumps over the lazy dog the quick fox";
        String[] words = text.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");
        Map<String, Integer> bigramCount = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String bigram = words[i] + " " + words[i + 1];
            bigramCount.put(bigram, bigramCount.getOrDefault(bigram, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : bigramCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
