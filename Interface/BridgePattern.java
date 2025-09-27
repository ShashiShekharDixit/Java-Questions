abstract class Shape {
    protected Renderer renderer;
    protected Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    public abstract void draw();
}
interface Renderer {
    void renderCircle(float radius);
    void renderRectangle(float width, float height);
}
class VectorRenderer implements Renderer {
    public void renderCircle(float radius) {
        System.out.println("Drawing Circle with radius " + radius + " using Vectors.");
    }
    public void renderRectangle(float width, float height) {
        System.out.println("Drawing Rectangle " + width + "x" + height + " using Vectors.");
    }
}
class RasterRenderer implements Renderer {
    public void renderCircle(float radius) {
        System.out.println("Drawing Circle with radius " + radius + " using Pixels.");
    }
    public void renderRectangle(float width, float height) {
        System.out.println("Drawing Rectangle " + width + "x" + height + " using Pixels.");
    }
}
class Circle extends Shape {
    private float radius;
    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }
    public void draw() {
        renderer.renderCircle(radius);
    }
}
class Rectangle extends Shape {
    private float width, height;
    public Rectangle(Renderer renderer, float width, float height) {
        super(renderer);
        this.width = width;
        this.height = height;
    }
    public void draw() {
        renderer.renderRectangle(width, height);
    }
}
public class BridgePattern {
    public static void main(String[] args) {
        Renderer vector = new VectorRenderer();
        Renderer raster = new RasterRenderer();
        Shape circle1 = new Circle(vector, 5);
        Shape circle2 = new Circle(raster, 7);
        Shape rect1 = new Rectangle(vector, 4, 6);
        Shape rect2 = new Rectangle(raster, 3, 8);
        circle1.draw();
        circle2.draw();
        rect1.draw();
        rect2.draw();
    }
}
