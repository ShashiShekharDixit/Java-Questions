import java.util.function.Function;

public class UnaryOperatorPipeline {
    public static void main(String[] args) {
        double price = 100.0;
        Function<Double, Double> tax = p -> p * 1.1;
        Function<Double, Double> discount = p -> p * 0.95;
        Function<Double, Double> round = p -> Math.round(p * 100.0) / 100.0;
        Function<Double, Double> finalPricePipeline = tax.andThen(discount).andThen(round);
        double finalPrice = finalPricePipeline.apply(price);
        System.out.println("Original price: " + price);
        System.out.println("Final price after tax, discount, and rounding: " + finalPrice);
    }
}
