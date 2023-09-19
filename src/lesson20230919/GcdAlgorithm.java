package lesson20230919;

public class GcdAlgorithm {

    // greatestCommonDeliver task
    public static void main(String[] args) {

        long start;
        long end;

        start = System.nanoTime();
        int result = findGcdEuclidean(121000, 33000);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("Time elapsed, ns: " + (end - start));

        start = System.nanoTime();
        result = findGcdBruteForce(121000, 33000);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("Time elapsed, ns: " + (end - start));

    }

    // Алгоритм Евклида
    //
    //Формула НОД: НОД (a, b) = НОД (b, с), где с — остаток от деления a на b.
    //
    //1 Большее число поделить на меньшее.
    //2 Меньшее число поделить на остаток, который получается после деления.
    //3 Первый остаток поделить на второй остаток.
    //4 Второй остаток поделить на третий и т. д.
    //5 Деление продолжается до тех пор, пока в остатке не получится нуль. Последний делитель и есть наибольший общий делитель.
    public static int findGcdEuclidean(int a, int b) {
        int x = Math.min(a, b);
        int y = Math.max(a, b);
        int tmp = x;

        while (tmp != 0) {
            tmp = y % x;
            y = x;
            x = tmp;
        }
        return y;
    }

    public static int findGcdBruteForce(int a, int b) {
        int x = Math.min(a, b);
        int y = Math.max(a, b);

        for (int i = x; i > 1; i--) {
            if (x % i == 0 && y % i == 0) return i;
        }
        return 1;
    }


}
