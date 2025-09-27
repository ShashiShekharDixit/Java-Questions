import java.util.*;
public class SetOperations {
    static <T extends Comparable<T>> List<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        List<T> list = new ArrayList<>(result);
        Collections.sort(list);
        return list;
    }
    static <T extends Comparable<T>> List<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        List<T> list = new ArrayList<>(result);
        Collections.sort(list);
        return list;
    }
    static <T extends Comparable<T>> List<T> difference(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.removeAll(b);
        List<T> list = new ArrayList<>(result);
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        System.out.println("Union: " + union(setA, setB));
        System.out.println("Intersection: " + intersection(setA, setB));
        System.out.println("Difference (A-B): " + difference(setA, setB));
    }
}
