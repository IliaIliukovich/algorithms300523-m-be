package lesson20231017;

public class CountSum {

    public static void main(String[] args) {

        System.out.println(sum(10, 3));


    }

    public static int sum(int n, int m){
        int p = n / m;
        int N = p * m;
        int sum = sumRecursive(N, m);
        return sum;
    }

    private static int sumRecursive(int n, int m) {
        if (n <= 0) return 0;
        return n + sumRecursive(n - m, m);
    }


}
