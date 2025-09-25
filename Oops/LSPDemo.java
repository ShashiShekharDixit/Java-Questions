class Rectangle {
    protected int width;
    protected int height;
    void setWidth(int width) {
        this.width = width;
    }
    void setHeight(int height) {
        this.height = height;
    }
    int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    void setWidth(int width) {
        this.width = width;
        this.height = width; 
    }

    @Override
    void setHeight(int height) {
        this.width = height;
        this.height = height; 
    }
}
class FixedSquare {
    private Rectangle rect;

    FixedSquare(int side) {
        rect = new Rectangle();
        rect.setWidth(side);
        rect.setHeight(side);
    }

    int getArea() {
        return rect.getArea();
    }
}
public class LSPDemo {
    public static void main(String[] args) {
        System.out.println("=== LSP Violation Example ===");
        Rectangle rect = new Rectangle();
        rect.setWidth(5);
        rect.setHeight(10);
        System.out.println("Rectangle area = " + rect.getArea()); 

        Rectangle sq = new Square(); 
        sq.setWidth(5);
        sq.setHeight(10);
        System.out.println("Square area = " + sq.getArea()); 

        System.out.println("\n=== Fixed Version (Composition) ===");
        FixedSquare fixedSq = new FixedSquare(10);
        System.out.println("FixedSquare area = " + fixedSq.getArea()); 
    }
}
