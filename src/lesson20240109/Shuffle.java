package lesson20240109;

import java.util.*;

public class Shuffle {


    // v. 1
    //1 2 2 3 4
    //0 1 -1 3 10 sort()
    //-1 0 1 3 10
    //
    //2 1 2 3 4
    //
    //space - O(n)
    //time - O(n * log n)

    public static void main(String[] args) {
        Integer[] data = {1 ,2 ,3, 4, 5};
        shuffle(data);

        System.out.println(Arrays.toString(data));
        List<Integer> dataList = new ArrayList<>();
        dataList.add(1);
        dataList.add(2);
        dataList.add(3);
        dataList.add(4);
        dataList.add(5);
        Collections.shuffle(dataList);
        System.out.println(dataList);
    }

    public static void shuffle(Integer[] data) {  // O(n)
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            swap(data, i, random.nextInt(i +  1));
//            swap(data, i, random.nextInt(data.length)); // this solution will not give uniformly distribution
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
