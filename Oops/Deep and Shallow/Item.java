public class Item {
    String name;
    int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Item(Item other) {
        this.name = other.name;
        this.quantity = other.quantity;
    }

    @Override
    public String toString() {
        return name + "(" + quantity + ")";
    }
}
