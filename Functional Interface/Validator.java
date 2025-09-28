import java.util.function.Predicate;

public class Validator {
    public static Predicate<Integer> rangeValidator(int min, int max) {
        return n -> n >= min && n <= max; 
    }
    public static void main(String[] args) {
        Predicate<Integer> ageValidator = rangeValidator(18, 60);
        Predicate<Integer> scoreValidator = rangeValidator(0, 100);
        int age = 25;
        int score = 105;
        System.out.println("Age valid : " + ageValidator.test(age));      
        System.out.println("Score valid : " + scoreValidator.test(score)); 
        if (ageValidator.test(age)) {
            System.out.println("Age is acceptable.");
        }
    }
}
