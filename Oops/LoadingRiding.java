class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {  
        return a + b;
    }
}
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}
class Dog extends Animal {
    @Override
    void sound() {  
        System.out.println("Dog barks");
    }
}
public class LoadingRiding {
    public static void main(String[] args) {
        System.out.println("-> Method Overloading <-");
        Calculator calc = new Calculator();
        System.out.println("add(int, int): " + calc.add(5, 10));       
        System.out.println("add(double, double): " + calc.add(5.5, 2.5)); 
        System.out.println("\n-> Method Overriding <-");
        Animal a = new Animal();
        a.sound();  
        Animal d = new Dog(); 
        d.sound();  
    }
}
