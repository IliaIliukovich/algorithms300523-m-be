package lesson20231710;

public class Fibonacci {

    public static void main(String[] args) {
        // 2 6 18 54  * 3 геом. прогрессия
        // 2 5 8 11 14 + 3 арифм. прогрессия

        // 0 1 1 2 3 5 8 13 21
        // fibonacci(0) = 0
        // fibonacci(1) = 1
        // fibonacci(2) = 1
        // fibonacci(3) = 2
        // fibonacci(4) = 3
        // fibonacci(5) = 5
        // fibonacci(6) = 8

        long start = System.nanoTime();
        int result = fibonacciRecursiveMemo(45);
        long end = System.nanoTime();
        System.out.println(result);
        System.out.println("Elapsed time RecursiveMemo alg: " + (end - start));
        start = System.nanoTime();
        result = fibonacciRecursive(45);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("Elapsed time Recursive alg: " + (end - start));
    }

    public static int fibonacciRecursive(int n) {
        if (n == 0) return 0; // base condition
        if (n == 1) return 1; // base condition
        return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
    }

    public static int fibonacciRecursiveMemo(int n) {
        if (n == 0) return 0; // base condition
        if (n == 1) return 1; // base condition
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        return fibonacciRecursiveMemo(n - 2, arr) + fibonacciRecursiveMemo(n - 1, arr);
    }

    private static int fibonacciRecursiveMemo(int n, int[] arr) {
        if (n == 0) return 0; // base condition
        if (n == 1) return 1; // base condition
        if (arr[n] != 0) return arr[n]; // cache
        arr[n] = fibonacciRecursiveMemo(n - 2, arr) + fibonacciRecursiveMemo(n - 1, arr);
        return arr[n];
    }


}
