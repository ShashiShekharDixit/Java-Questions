class AppException extends Exception {
    public AppException(String message) {
        super(message);
    }
}

class InvalidInputException extends AppException {
    public InvalidInputException(String message) {
        super(message);
    }
}

class DataNotFoundException extends AppException {
    public DataNotFoundException(String message) {
        super(message);
    }
}

class AppRuntimeException extends RuntimeException {
    public AppRuntimeException(String message) {
        super(message);
    }
}

class NullValueException extends AppRuntimeException {
    public NullValueException(String message) {
        super(message);
    }
}

class CalculationException extends AppRuntimeException {
    public CalculationException(String message) {
        super(message);
    }
}

public class ExceptionHierarchyDemo {
    static void loadData(String input) throws AppException {
        if (input == null || input.isBlank()) {
            throw new InvalidInputException("Input cannot be null or empty");
        }
        if (input.equals("missing")) {
            throw new DataNotFoundException("Data not found for: " + input);
        }
        System.out.println("Data loaded successfully: " + input);
    }

    static int divide(int a, int b) {
        if (b == 0) {
            throw new CalculationException("Division by zero not allowed");
        }
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println("-> Checked Exceptions Demo <-");
        try {
            loadData("");   
        } catch (AppException e) {
            System.out.println("Handled checked exception: " + e.getMessage());
        }

        try {
            loadData("missing"); 
        } catch (AppException e) {
            System.out.println("Handled checked exception: " + e.getMessage());
        }

        try {
            loadData("validData"); 
        } catch (AppException e) {
            System.out.println("Handled checked exception: " + e.getMessage());
        }

        System.out.println("\n-> Unchecked Exceptions Demo <-");
        try {
            int result = divide(10, 0); 
            System.out.println("Result: " + result);
        } catch (AppRuntimeException e) {
            System.out.println("Caught runtime exception: " + e.getMessage());
        }
    }
}
