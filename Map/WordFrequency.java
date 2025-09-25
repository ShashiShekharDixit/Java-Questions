import java.util.HashMap;

public class WordFrequency{
    public static void main(String[] args) {
        String text = "Hello world! Hello Java. Java is fun, and Java is powerful.";
        text = text.toLowerCase().replaceAll("[^a-z A-Z 0-9 ]", "");

        String[] words = text.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1); 
            } else {
                map.put(word, 1); 
            }
        }

        for (String word : map.keySet()) {
            System.out.println(word + " -> " + map.get(word));
        }
    }
}
