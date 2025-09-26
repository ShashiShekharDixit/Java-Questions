interface DiscountStrategy {
    double applyDiscount(double price);
}
class Order {
    private double price;
    private DiscountStrategy discountStrategy;
    Order(double price, DiscountStrategy discountStrategy) {
        this.price = price;
        this.discountStrategy = discountStrategy;
    }
    double getFinalPrice() {
        return discountStrategy.applyDiscount(price);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        Order order1 = new Order(1000, price -> price);
        System.out.println("Final price (No discount): " + order1.getFinalPrice());
        Order order2 = new Order(1000, price -> price - (price * 10 / 100));
        System.out.println("Final price (10% discount): " + order2.getFinalPrice());
        Order order3 = new Order(1000, price -> Math.max(0, price - 150));
        System.out.println("Final price (Flat $150 off): " + order3.getFinalPrice());
    }
}