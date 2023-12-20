package lesson20231219;

import lesson20230919.SearchAlgorithms;

public class CountElements {

    public static void main(String[] args) {
        System.out.println(countElements(new int[] {1, 2, 2, 2, 2, 3, 4}, 2));
    }

    public static int countElements(int[] array, int element) {
        int position = SearchAlgorithms.searchBinary(array, element);
        if (position == - 1) return 0;
        return count(array, position);
    }

    private static int count(int[] array, int position) {
        int count = 1;
        int i = 1;
        while (position - i >= 0 && array[position - i++] == array[position]){
            count++;
        }
        i = 1;
        while (position + i < array.length && array[position + i++] == array[position]){
            count++;
        }
        return count;
    }


}
