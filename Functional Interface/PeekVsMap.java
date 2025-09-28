import java.util.*;
import java.util.stream.Collectors;

public class PeekVsMap {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("shashi", "shekhar", "Dixit");
        List<String> upperNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Uppercase names: " + upperNames);
        List<String> peekedNames = names.stream().peek(name -> 
        System.out.println("Processing: " + name)).map(String::toLowerCase).collect(Collectors.toList());
        System.out.println("Lowercase names: " + peekedNames);
    }
}
