import java.util.*;
interface SortStrategy {
    <T> void sort(List<T> list, Comparator<T> comparator);
}
class DefaultSortStrategy implements SortStrategy {
    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        Collections.sort(list, comparator);
    }
}
class Sorter {
    private SortStrategy strategy;
    Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        strategy.sort(list, comparator);
    }
}
public class StrategySort {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Shashi", "Saurabh", "Pankaj"));
        Sorter sorter = new Sorter(new DefaultSortStrategy());
        sorter.sort(names, Comparator.naturalOrder());
        System.out.println("Ascending: " + names);
        sorter.sort(names, Comparator.reverseOrder());
        System.out.println("Descending: " + names);
        sorter.sort(names, Comparator.comparingInt(String::length));
        System.out.println("By length: " + names);
    }
}
