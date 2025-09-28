import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class RowSumTask implements Runnable {
    private final int[] row;
    private final int rowIndex;
    private final int[] partialSums;
    private final CyclicBarrier barrier;
    RowSumTask(int[] row, int rowIndex, int[] partialSums, CyclicBarrier barrier) {
        this.row = row;
        this.rowIndex = rowIndex;
        this.partialSums = partialSums;
        this.barrier = barrier;
    }
    @Override
    public void run() {
        int sum = 0;
        for (int val : row) {
            sum += val;
        }
        partialSums[rowIndex] = sum;
        System.out.println("Row " + rowIndex + " sum = " + sum);
        try {
            barrier.await(); 
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }
}
public class CyclicBarrierMatrixSum {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},     
            {4, 5, 6},     
            {7, 8, 9}      
        };
        int rows = matrix.length;
        int[] partialSums = new int[rows];
        CyclicBarrier barrier = new CyclicBarrier(rows, () -> {
            int total = 0;
            for (int s : partialSums) {
                total += s;
            }
            System.out.println("Total sum of matrix = " + total);
        });
        for (int i = 0; i < rows; i++) {
            new Thread(new RowSumTask(matrix[i], i, partialSums, barrier)).start();
        }
    }
}
