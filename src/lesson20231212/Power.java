package lesson20231212;

public class Power {


    // Даны два целых числа x и n, напишите функцию для вычисления x^n
    //	 решение 1 - O(n)
    //	 решение 2 - улучшить решение до O(lon n)
    public static void main(String[] args) {

        System.out.println(power(2, 8));
        System.out.println(powerDivideAndConquer(2, 8));
        System.out.println(powerDivideAndConquer(2, 7));

    }

    // 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2   // 7 ---- O(n)

    // ((2 * 2) * 2 * 2) * (2 * 2 * 2 * 2)   // O(log(n))
    // 2^8 = 2^4 * 2^4    // 1    // 3 operations
    // 2^4 = 2^2 * 2^2   // 1
    // 2^2 = 2 * 2      // 1

    // 2^7 = 2*2^6

    public static int power(int x, int n) {
        int result = x;
        for (int i = 0; i < n - 1; i++) {
            result = result * x;
        }
        return result;
    }

    public static int powerDivideAndConquer(int x, int n) {
        if (n == 1) return x;
        if(n % 2 == 0) {
            int result = powerDivideAndConquer(x, n / 2);
            return result * result;
        } else {
            return x * powerDivideAndConquer(x, n - 1);
        }
    }

}
