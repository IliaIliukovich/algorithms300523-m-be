package lesson20231219;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[] {1, 8, 3, 4, 2, 0};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    // O(n log n)
    public static void mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        sort(array, tmp, 0, array.length - 1);
    }

    private static void sort(int[] array, int[] tmp, int start, int end){
        if (start == end) return; // base condition
        int middle = start + (end - start) / 2;
        sort(array, tmp, start, middle);
        sort(array, tmp, middle + 1, end);
        merge(array, tmp, start, middle, end);
    }

    private static void merge(int[] array, int[] tmp, int start, int middle, int end) {
        for (int k = start; k <= end; k++) {
            tmp[k] = array[k];
        }
        int i = start;
        int j = middle + 1;
        for (int k = start; k <= end; k++) {
            if (i > middle) array[k] = tmp[j++];
            else if (j > end) array[k] = tmp[i++];
            else if (tmp[i] <= tmp[j]) array[k] = tmp[i++];
            else array[k] = tmp[j++];
        }

    }
}
