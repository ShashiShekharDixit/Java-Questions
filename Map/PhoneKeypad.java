import java.util.*;
public class PhoneKeypad {
    private static final String[] KEYPAD = {
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"  
    };
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    private static void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = KEYPAD[digit];
        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(digits, index + 1, path, result);
            path.deleteCharAt(path.length() - 1); 
        }
    }
    public static void main(String[] args) {
        String digits = "23";
        List<String> combos = letterCombinations(digits);
        System.out.println("Phone keypad combinations for " + digits + ":");
        System.out.println(combos);
    }
}
