import java.util.*;
public class DistinctSubstrings {
    public static int countDistinctSubstrings(String s) {
        Set<String> substrings = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                substrings.add(s.substring(i, j));
            }
        }
        return substrings.size();
    }
    public static void main(String[] args) {
        String str = "ababa";
        int count = countDistinctSubstrings(str);
        System.out.println("Number of distinct substrings: " + count);
    }
}
