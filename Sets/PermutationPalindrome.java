import java.util.*;
public class PermutationPalindrome {
    public static boolean canFormPalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') { 
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
        }
        int oddCount = 0;
        for (int freq : count.values()) {
            if (freq % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
    public static void main(String[] args) {
        String str1 = "civic";
        String str2 = "ivicc";
        String str3 = "hello";
        System.out.println(str1 + ": " + canFormPalindrome(str1));
        System.out.println(str2 + ": " + canFormPalindrome(str2));
        System.out.println(str3 + ": " + canFormPalindrome(str3));
    }
}
