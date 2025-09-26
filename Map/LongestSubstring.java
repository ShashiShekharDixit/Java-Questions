import java.util.*;
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int maxLen = 0;
        int start = 0; 
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (lastIndex.containsKey(c)) {
                start = Math.max(start, lastIndex.get(c) + 1); 
            }
            lastIndex.put(c, end); 
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "abcabgjcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}
