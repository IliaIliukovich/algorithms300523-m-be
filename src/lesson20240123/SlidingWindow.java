package lesson20240123;

public class SlidingWindow {

    // Дан массив целых чисел размера «n»,
    // требуется вычислить максимальную сумму «k» последовательных элементов в массиве.
    public static void main(String[] args) {
        int[] data = {9, 4, 5, 1, 7, 3, 10};
        int k = 3;
        System.out.println(findMaxSum(data, k));
    }

    public static int findMaxSum(int[] data, int k) { // O(n)
        int sumMax = 0;
        for (int i = 0; i < k; i++) {
            sumMax += data[i];
        }

        int currentWindow = sumMax;
        for (int i = k; i < data.length; i++) {
            currentWindow = currentWindow - data[i - k] + data[i];
            sumMax = Math.max(sumMax, currentWindow);
        }
        return sumMax;
    }


}
