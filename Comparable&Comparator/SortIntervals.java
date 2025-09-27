import java.util.*;
public class SortIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
            {5, 7},
            {1, 3},
            {2, 6},
            {8, 10},
            {2, 4}
        };
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); 
            } else {
                return Integer.compare(a[1], b[1]); 
            }
        });
        for (int[] in : intervals) {
            System.out.println(Arrays.toString(in));
        }
    }
}
