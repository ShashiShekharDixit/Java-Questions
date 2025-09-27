import java.util.*;
public class NullSafeSort {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Shashi", null, "Shekhar", "Saurabh", null, "Sachin");
        List<String> nullsFirst = new ArrayList<>(names);
        nullsFirst.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("Nulls first: " + nullsFirst);
        List<String> nullsLast = new ArrayList<>(names);
        nullsLast.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("Nulls last: " + nullsLast);
    }
}
