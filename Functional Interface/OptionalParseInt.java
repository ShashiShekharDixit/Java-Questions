import java.util.Optional;

public class OptionalParseInt {
    public static void main(String[] args) {
        String[] inputs = { "42", "abc", null, "100" };
        for (String s : inputs) {
            Optional<Integer> parsed = Optional.ofNullable(s).flatMap(str -> {
            try {
                return Optional.of(Integer.parseInt(str));
            } catch (NumberFormatException e) {
            return Optional.empty();
            }
            });
            System.out.println("Input: " + s + " -> Parsed: " + parsed);
        }
    }
}
