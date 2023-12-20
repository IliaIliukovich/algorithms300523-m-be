package lesson20231219;

import lesson20231205.Book;

import java.util.Arrays;
import java.util.Comparator;

public class SelectionSort {

    public static void main(String[] args) {
        Integer[] array = {1, 3, 5, 2, 0, 10};
        selectionSort(array, Comparator.comparingInt(value -> (int) value));
        System.out.println(Arrays.toString(array));

        Book book1 = new Book("Harry Potter1", 50.0, true);
        Book book2 = new Book("Harry Potter2", 50.0, true);
        Book book3 = new Book("Harry Potter3", 50.0, true);
        Book book4 = new Book("Harry Potter4", 10.0, true);
        Book book5 = new Book("Harry Potter5", 10.0, true);
        Book[] books = {book1, book2, book3, book4, book5};

        selectionSort(books, Comparator.comparing(value -> ((Book) value).getName()));
        System.out.println(Arrays.toString(books));

        // selection sort - unstable
        selectionSort(books, Comparator.comparingDouble(value -> ((Book) value).getPrice()));
        System.out.println(Arrays.toString(books));

        // merge sort - stable
//        Arrays.sort(books, Comparator.comparingDouble(value -> ((Book) value).getPrice()));
//        System.out.println(Arrays.toString(books));
    }

    // best case O(n^2)
    // worst case O(n^2)
    public static void selectionSort(Object[] array, Comparator comparator) {
        for (int i = 0; i < array.length; i++) {
            Object min = array[i];
            int indMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (comparator.compare(array[j], min) < 0){
                    indMin = j;
                    min = array[j];
                }
            }
            swap(array, i, indMin);
        }
    }

    private static void swap(Object[] array, int i, int j) {
        if (i != j) {
            Object tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

}
