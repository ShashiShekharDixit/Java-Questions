import java.util.HashMap;
public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String text = "swiss";

        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        char firstNonRepeating = 0; 
        for (char c : text.toCharArray()) {
            if (countMap.get(c) == 1) {
                firstNonRepeating = c;
                break;
            }
        }

        if (firstNonRepeating != 0){
            System.out.println("First non-repeating character: " + firstNonRepeating);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
