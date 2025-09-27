@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);  
}

public class ConverterLambda {
    public static void main(String[] args) {
        Converter<String, Integer> stringToInt = s -> Integer.parseInt(s);     
        System.out.println("Lambda: " + stringToInt.convert("123"));
        Converter<String, Double> stringToDouble = Double::parseDouble;    
        System.out.println("Method Reference: " + stringToDouble.convert("45.67"));
        Converter<Integer, String> intToHex = n -> "0x" + Integer.toHexString(n);   
        System.out.println("Custom Lambda: " + intToHex.convert(255));
    }
}
