import java.util.*;
public class RemoveVowelsUnique {
    public static String removeVowelsUnique(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        Set<Character> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!vowels.contains(c) && !seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "Programming is fun";
        String result = removeVowelsUnique(str);
        System.out.println("Result: " + result);
    }
}
