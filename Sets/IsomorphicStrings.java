import java.util.*;
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (mapST.containsKey(cs) && mapST.get(cs) != ct) return false;
            if (mapTS.containsKey(ct) && mapTS.get(ct) != cs) return false;
            mapST.put(cs, ct);
            mapTS.put(ct, cs);
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "egg";
        String t1 = "add";
        System.out.println(s1 + " and " + t1 + " are isomorphic = " + isIsomorphic(s1, t1));
        String s2 = "foo";
        String t2 = "bar";
        System.out.println(s2 + " and " + t2 + " are isomorphic = " + isIsomorphic(s2, t2));
    }
}
