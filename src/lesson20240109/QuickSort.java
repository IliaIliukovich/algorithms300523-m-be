package lesson20240109;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] data = {6, 3, 4, 2, 1, 5};

//        System.out.println(partition(data, 0, data.length - 1));

        sort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void sort(Integer[] data) { // O(n * log n)
        Shuffle.shuffle(data); // O(n)
        sort(data, 0, data.length - 1); // O(n * log n)
    }

    private static void sort(Integer[] data, int start, int end) {
        if (start >= end) return; // base condition

        int pivotIndex = partition(data, start, end);
        sort(data, start, pivotIndex - 1);
        sort(data, pivotIndex + 1, end);
    }

    private static int partition(Integer[] data, int start, int end) {
        int pivot = data[start];
        int i = start;
        int j = end + 1;

        while (true) {
            while (data[++i] < pivot) {
                if (i == end) break;
            }

            while (data[--j] > pivot) {
                if (j == start) break;
            }

            if (i >= j) break;
            swap(data, i, j);
        }
        swap(data, start, j);
        return j;
    }

    private static void swap(Object[] array, int i, int j) {
        if (i != j) {
            Object tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

}
