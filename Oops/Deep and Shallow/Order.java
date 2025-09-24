import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items;

    public Order() {
        this.items = new ArrayList<>();
    }
    public void addItem(Item item) {
        items.add(item);
    }
    public List<Item> getItems() {
        return items;
    }
    public Order(Order other, boolean shallow) {
        if (shallow) {
            this.items = other.items; 
        } else {
            this.items = new ArrayList<>();
            for (Item item : other.items) {
                this.items.add(new Item(item));
            }
        }
    }
    public Item findItemByName(String name) {
        for (Item item : items) {
            if (item.name.equalsIgnoreCase(name)) {
                return item; 
            }
        }
        return null; 
    }
    @Override
    public String toString() {
        return items.toString();
    }
}
