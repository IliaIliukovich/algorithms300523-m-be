package lesson20240109;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortExamples {

    public static void main(String[] args) {

        int[] ints = {1, 1, 3, 2};
        Arrays.sort(ints); // quick sort O(N*logN)

        String[] strings = {"A", "C", "B"};
        Arrays.sort(strings); // merge sort  O(N*logN)

        List<String> list = Arrays.asList("C", "A", "B");
        Collections.sort(list); // merge sort O(N*logN)
    }



}
