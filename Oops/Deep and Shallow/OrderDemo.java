public class OrderDemo {
    public static void main(String[] args) {
        Order original = new Order();
        original.addItem(new Item("Apple", 5));
        original.addItem(new Item("Banana", 10));

        System.out.println("Original: " + original);
        Order shallow = new Order(original, true);
        shallow.getItems().get(0).quantity = 100; 
        System.out.println("Shallow copy after change: " + shallow);
        System.out.println("Original after shallow change: " + original); 

        Order deep = new Order(original, false);
        deep.getItems().get(0).quantity = 50; 
        System.out.println("Deep copy after change: " + deep);
        System.out.println("Original after deep change: " + original); 

        Item found = original.findItemByName("Banana");
        if (found != null) {
            System.out.println("Found item: " + found);
        } else {
            System.out.println("Item not found!");
        }
    }
}
