package lesson20230926;

public class BinarySearchForUniqueElement {

// Дан отсортированный массив, в котором все элементы встречаются дважды (один за другим),
// а один элемент появляется только один раз.
// Написать метод для нахождения этого элемента.

    public static void main(String[] args) {
        int[] array = new int[] {1, 1, 2, 2, 3};
        System.out.println(find(array));
    }

    public static int find(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start != end) {
            int middle = (end - start) / 2 + start;
            if (array[middle] != array[middle - 1] && array[middle] != array[middle + 1]) return array[middle];

            int leftCount;
            boolean isDoubleLetterToLeft = array[middle] == array[middle - 1];
            if (isDoubleLetterToLeft) {
                leftCount = middle - 1 - start;
            } else {
                leftCount = middle - start;
            }

            if (leftCount % 2 == 1) {
                end = isDoubleLetterToLeft ? middle - 2 : middle - 1;
            } else {
                start = isDoubleLetterToLeft ? middle + 1 : middle + 2;
            }
        }
        return array[start];
    }

}

