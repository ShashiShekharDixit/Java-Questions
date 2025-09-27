interface Shape {
    double area();
}
record Circle(double radius) implements Shape {
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
record Rectangle(double width, double height) implements Shape {
    @Override
    public double area() {
        return width * height;
    }
}
public class InterfaceandRecord {
    public static void main(String[] args) {
        Shape c = new Circle(3);
        Shape r = new Rectangle(4, 5);
        System.out.println(c);           
        System.out.println(r);           
        System.out.println("Circle area: " + c.area());
        System.out.println("Rectangle area: " + r.area());
        Shape c2 = new Circle(3);
        System.out.println("c equals c2? " + c.equals(c2)); 
    }
}
