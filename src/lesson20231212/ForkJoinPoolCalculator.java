package lesson20231212;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinPoolCalculator extends RecursiveTask<Long> {

    // Параллельнное вычисление суммы всех чисел в массиве с помощью ForkJoinPool

    public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();
    public static final long THRESHOLD = 10_000;

    private final long[] numbers;
    private final int start;
    private final int end;

    public ForkJoinPoolCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinPoolCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJoinPoolCalculator leftTask = new ForkJoinPoolCalculator(numbers, start, start + length/2);
        leftTask.fork();
        ForkJoinPoolCalculator rightTask = new ForkJoinPoolCalculator(numbers, start + length/2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] numbersArray = LongStream.rangeClosed(1, 100_000_000).toArray(); // input data
        ForkJoinTask<Long> task = new ForkJoinPoolCalculator(numbersArray);
        long sum = FORK_JOIN_POOL.invoke(task);
        System.out.println(sum);
    }
}
