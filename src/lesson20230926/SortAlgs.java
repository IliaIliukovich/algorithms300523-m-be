package lesson20230926;

import java.util.Arrays;
import java.util.Random;

public class SortAlgs {

    public static void main(String[] args) {

        int[] numbers = new int[] {1, 5, 4, 5, -10, 0, 8 ,99};
        sortBruteForce(numbers);
        System.out.println(Arrays.toString(numbers));

        numbers = new int[] {1, 5, 4, 5, -10, 0, 8 ,99};
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));

        // Arrays.sort() vs Selection Sort
        int n = 50000;
        int[] testData = generateTestData(n);
        long start = System.nanoTime();
        Arrays.sort(testData);
        long end = System.nanoTime();
        System.out.println("Arrays.sort() time elapsed: " + (end - start));

        int[] testData2 = generateTestData(n);
        start = System.nanoTime();
        selectionSort(testData2);
        end = System.nanoTime();
        System.out.println("Selection sort time elapsed: " + (end - start));
    }

    private static int[] generateTestData(int n) {
        Random random = new Random();
        int[] testData = new int[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt();
        }
        return testData;
    }

    public static void sortBruteForce(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int min = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < min){
                    min = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = min;
                }
            }
        }
    }

    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int min = numbers[i];
            int indMin = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < min){
                    indMin = j;
                    min = numbers[j];
                }
            }
            min = numbers[i];
            numbers[i] = numbers[indMin];
            numbers[indMin] = min;
        }
    }

}
