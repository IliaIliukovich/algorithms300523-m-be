package lesson20230926;

public class SumElements {

    public static void main(String[] args) {
        System.out.println(sumElementsRecursive(10));
        System.out.println(sumInLoop(10));
    }

    public static int sumElementsRecursive(int n) {
        if (n == 1) return 1; // base condition
        return n + sumElementsRecursive(n - 1);
    }

    public static int sumInLoop(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = result + i;
        }
        return result;
    }

}
