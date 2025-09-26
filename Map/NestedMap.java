import java.util.HashMap;
import java.util.Map;

public class NestedMap {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> salesData = new HashMap<>();
        addSale(salesData, "Lucknow", "January", 1200);
        addSale(salesData, "Bangalore", "February", 1500);
        addSale(salesData, "Delhi", "January", 900);
        addSale(salesData, "Kolkata", "February", 1100);
        addSale(salesData, "Mumbai", "January", 800);
        for (var cityEntry : salesData.entrySet()) {
            System.out.println(cityEntry.getKey() + " -> " + cityEntry.getValue());
        }
    }
    private static void addSale(Map<String, Map<String, Integer>> salesData,String city, String month, int amount) {
        salesData.computeIfAbsent(city, c -> new HashMap<>()).put(month, amount);
    }
}
