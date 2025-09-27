import java.util.*;
class Item {
    String name;
    int value;
    Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
    @Override
    public String toString() {
        return name + "(" + value + ")";
    }
}
public class StableVsUnstableSort {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
            new Item("A", 5),
            new Item("B", 3),
            new Item("C", 5),
            new Item("D", 2),
            new Item("E", 3)
        );
        List<Item> stableSorted = new ArrayList<>(items);
        Collections.sort(stableSorted, Comparator.comparingInt(i -> i.value));
        System.out.println("Stable sort by value: " + stableSorted);
        List<Item> unstableSorted = new ArrayList<>(items);
        unstableSorted.sort((i1, i2) -> i1.value - i2.value); 
        System.out.println("Unstable sort by value: " + unstableSorted);
    }
}
