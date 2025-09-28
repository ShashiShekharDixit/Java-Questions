import java.util.*;
import java.util.concurrent.*;

public class ParallelSum {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1; 
        }
        int numThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int chunkSize = (int) Math.ceil((double) arr.length / numThreads);
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int t = 0; t < numThreads; t++) {
            int start = t * chunkSize;
            int end = Math.min(start + chunkSize, arr.length);
            if (start >= end) break; 
            final int s = start, e = end;
            tasks.add(() -> {
                int sum = 0;
                for (int i = s; i < e; i++) {
                    sum += arr[i];
                }
                System.out.println("Task " + s + "-" + (e - 1) + " sum = " + sum);
                return sum;
            });
        }
        List<Future<Integer>> results = executor.invokeAll(tasks);
        int total = 0;
        for (Future<Integer> f : results) {
            total += f.get();
        }
        executor.shutdown();
        System.out.println("Final Sum = " + total);
    }
}
