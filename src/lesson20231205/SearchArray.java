package lesson20231205;

import java.util.HashMap;
import java.util.Map;

public class SearchArray {

    // Task 1. Первый элемент, встречающийся k раз в массиве
    // Дан массив из n целых чисел. Задача состоит в том, чтобы найти первый элемент, который встречается k раз.
    // Если ни один элемент не встречается k раз, выведите -1.
    // Распределение целочисленных элементов может быть в любом диапазоне.
    //
    // Ввод : {1, 7, 4, 3, 4, 8, 7}, k = 2
    // Вывод : 7
    // Объяснение: И 7, и 4 встречаются 2 раза. Но 7 — это первое, которое встречается 2 раза.

    public static void main(String[] args) {
        System.out.println(search(new int[] {1, 7, 4, 3, 4, 8, 7, 4}, 3));
    }

    public static int search(int[] array, int k) { // O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
//            if (map.containsKey(array[i])){
//                map.put(array[i], map.get(array[i]) + 1);
//            } else {
//                map.put(array[i], 1);
//            }
            map.put(array[i], map.getOrDefault(array[i], 0) + 1); // O(1)
        }

        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == k) return array[i];
        }
        return -1;
    }

}
