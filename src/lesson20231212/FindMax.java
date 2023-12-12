package lesson20231212;

public class FindMax {

    public static void main(String[] args) {
        int[] data = {100, 6, 12, 1, 55, 99, 21 ,1000};
        System.out.println(findMax(data));
        System.out.println(findMaxDivideAndConquer(data, 0));
    }

    public static int findMaxDivideAndConquer(int[] data, int currentIndex) { // O(n)
        if (currentIndex == data.length - 1) return data[currentIndex]; // base condition
        int max = findMaxDivideAndConquer(data, currentIndex + 1);
        return Math.max(data[currentIndex], max);
    }

    public static int findMax(int[] data) { // O(n)
        int max = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) max = data[i];
        }
        return max;
    }


}
