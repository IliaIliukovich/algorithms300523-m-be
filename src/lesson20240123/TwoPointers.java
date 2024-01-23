package lesson20240123;

public class TwoPointers {


    // Дан отсортированный массив arr (отсортированный в порядке возрастания), содержащий N целых чисел,
    // найти, существует ли какая-либо пара элементов (arr[i], arr[j]), сумма которых равна k.
    public static void main(String[] args) {
        int[] data = {1, 3, 3, 6, 8, 11, 20};
        int k = 6;
        findSum(data, k);
    }

    public static void findSum(int[] data, int k) {
        int start = 0;
        int end = data.length - 1;
        int currentSum;

        while (start < end) {
            currentSum = data[start] + data[end];
            if (currentSum == k) {
                System.out.println("Solution found: a1 = " + data[start] + ", a2 = " + data[end]);
                return;
            } else if (currentSum < k) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println("Solution not found");
    }


}
