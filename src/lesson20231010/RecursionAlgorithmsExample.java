package lesson20231010;

public class RecursionAlgorithmsExample {

    public static void main(String[] args) {

        someRecursion(-10);
        someRecursion(990);

        int result = someRecursionWithReturnValue(5);
        System.out.println("Result = " + result);
        System.out.println(someRecursionWith2Args(5, 10));
    }

    public static void someRecursion(int n) {
        System.out.println("Currently n = " + n);
//        if (n == 100) return; // base condition
//        if (n == 1000) return; // base condition
        int nMin = 0;
        int nMax = 1000;
        if (n < nMin || n > nMax) return; // base condition
        someRecursion(n + 1);
    }

    public static int someRecursionWithReturnValue(int n) {
        System.out.println("Currently n = " + n);
//        if (n == -5) return -5; // base condition;
//        if (n == 0) return 0; // base condition for sum;
        if (n == 0) return 1; // base condition for multiply;
//        int value = 1 + someRecursionWithReturnValue(n - 1); // will return n
//        int value = n + someRecursionWithReturnValue(n - 1); // sum
        int value = n * someRecursionWithReturnValue(n - 1); // multiply
        System.out.println("Currently value = " + value);
        return value;
    }

    public static int someRecursionWith2Args(int n, int m) {
        if (n <= 0 || m <= 0) return 0; // base condition;
        int result = n + m + someRecursionWith2Args(n - 1, m - 1);
        return result;
    }

}
