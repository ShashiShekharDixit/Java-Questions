import java.util.*;
interface Shape {
    double area();
}
class Circle implements Shape {
    private double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
class Rectangle implements Shape {
    private double width, height;
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public double area() {
        return width * height;
    }
}
public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(3));       
        shapes.add(new Rectangle(4, 5)); 
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.area(); 
        }
        System.out.println("Total area of all shapes: " + totalArea);
    }
}