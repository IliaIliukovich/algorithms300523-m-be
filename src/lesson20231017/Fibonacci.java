package lesson20231017;

public class Fibonacci {

    public static void main(String[] args) {
        // 2 5 8 11 14 // + 3 арифмемическая прогрессия
        // 2 6 18 54  // * 3 геометрическая прогрессия

        // 0 1 1 2 3 5 8 13 21 // последовательность Фибоначчи
        // fibonacci(0) = 0
        // fibonacci(1) = 1
        // fibonacci(2) = 1
        // fibonacci(3) = 2
        // fibonacci(4) = 3
        // fibonacci(5) = 5
        // fibonacci(6) = 8

        long start = System.nanoTime();
        int result = fibonacciRecursive(45);
        long end = System.nanoTime();
        System.out.println("Result = " + result);
        System.out.println("Elapsed time, recursive alg: " + (end - start));

        start = System.nanoTime();
        result = fibonacciRecursiveMemo(45);
        end = System.nanoTime();
        System.out.println("Result = " + result);
        System.out.println("Elapsed time, recursiveMemo alg: " + (end - start));

        start = System.nanoTime();
        result = fibonacciTabulation(45);
        end = System.nanoTime();
        System.out.println("Result = " + result);
        System.out.println("Elapsed time tabulation alg: " + (end - start));
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
        return fibonacciRecursiveMemo(n, arr);
    }

    private static int fibonacciRecursiveMemo(int n, int[] arr) {
        if (n == 0) return 0; // base condition
        if (n == 1) return 1; // base condition
        if (arr[n] != 0) return arr[n]; // cache
        arr[n] = fibonacciRecursiveMemo(n - 1, arr) + fibonacciRecursiveMemo(n - 2, arr);
        return arr[n];
    }

    public static int fibonacciTabulation(int n){
        if (n == 0) return 0; // base condition
        if (n == 1) return 1; // base condition

        int cache1 = 0;
        int cache2 = 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = cache1 + cache2;
            cache1 = cache2;
            cache2 = result;
        }
        return result;
    }


}
