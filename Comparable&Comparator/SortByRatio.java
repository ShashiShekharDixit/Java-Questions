import java.util.*;
class Item {
    int profit;
    int weight;
    Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }
    double ratio() {
        return (double) profit / weight;
    }
    @Override
    public String toString() {
        return "{profit=" + profit + ", weight=" + weight + ", ratio=" + String.format("%.2f", ratio()) + "}";
    }
}
public class SortByRatio {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(60, 10));
        items.add(new Item(100, 20));
        items.add(new Item(120, 30));
        items.sort(Comparator.comparingDouble(Item::ratio).reversed());
        System.out.println("Items sorted by profit/weight ratio:");
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
