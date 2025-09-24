import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "Hello world! Hello Java. Java is fun, and Java is powerful.";
        text = text.toLowerCase().replaceAll("[^a-z A-Z 0-9\\s]", ""); 
        String[] words = text.split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word Frequency:");
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
