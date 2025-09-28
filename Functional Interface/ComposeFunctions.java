import java.util.function.Function;
public class ComposeFunctions {
    public static void main(String[] args) {
        String input = "   helloWorld   ";
        Function<String, String> trim = String::trim;
        Function<String, String> toUpper = String::toUpperCase;
        Function<String, String> last3 = s -> s.length() <= 3 ? s : s.substring(s.length() - 3);
        Function<String, String> pipeline = trim.andThen(toUpper).andThen(last3);
        String result = pipeline.apply(input);
        System.out.println("Original: \"" + input + "\"");
        System.out.println("Result after pipeline: \"" + result + "\"");
    }
}
