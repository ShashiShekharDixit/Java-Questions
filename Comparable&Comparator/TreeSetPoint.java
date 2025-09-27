import java.util.*;
class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
public class TreeSetPoint {
    public static void main(String[] args) {
        Set<Point> points = new TreeSet<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x != p2.x) return Integer.compare(p1.x, p2.x);
                return Integer.compare(p1.y, p2.y);
            }
        });
        points.add(new Point(2, 3));
        points.add(new Point(1, 5));
        points.add(new Point(2, 2));
        points.add(new Point(1, 5)); 
        points.add(new Point(3, 1));
        System.out.println("Points in sorted order:");
        for (Point p : points) {
            System.out.println(p);
        }
    }
}
