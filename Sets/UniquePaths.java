import java.util.*;
public class UniquePaths {
    static class Path {
        int a, b;
        Path(int a, int b) {
            if (a < b) {
                this.a = a;
                this.b = b;
            } else {
                this.a = b;
                this.b = a;
            }
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Path)) return false;
            Path other = (Path) o;
            return a == other.a && b == other.b;
        }
        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
        @Override
        public String toString() {
            return "(" + a + "," + b + ")";
        }
    }
    public static Set<Path> uniquePaths(int[][] paths) {
        Set<Path> unique = new HashSet<>();
        for (int[] p : paths) {
            unique.add(new Path(p[0], p[1]));
        }
        return unique;
    }
    public static void main(String[] args) {
        int[][] paths = {
            {1, 2},
            {2, 1},
            {3, 4},
            {4, 3},
            {2, 3}
        };
        Set<Path> unique = uniquePaths(paths);
        System.out.println("Unique undirected paths: " + unique);
    }
}
