package lesson20231710;

public class SeveralFunctions {

    public static void main(String[] args) {
        f1(10);
    }

    private static void f1(int n) {
        System.out.println("F1: " + n);
        f2(n - 1);
    }

    private static void f2(int n) {
        System.out.println("F2: " + n);
        if (n <= 0) return;
        f1(n - 1);
    }


}
