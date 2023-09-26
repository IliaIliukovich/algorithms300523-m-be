package lesson20230926;

public class CountSumOperations {


    public static void main(String[] args) {
        System.out.println(sum(3, 5));
        System.out.println(sum(new int[] {1, 2, 3}));
    }


    // time: O(3) = O(1)
    // space: O(1)
    public static int sum(int a, int b) {
        int result = a + b; // 2
        return result; // 1
    }

    // time: O(5n + 5) = O(1)
    // space: O(2) = O(1)
    public static int sum(int[] array){
        int result = 0; // 1
        for (int i = 0; i < array.length; i++) { // 3(n + 1)
            result = result + array[i]; // 2n
        }
        return result; // 1
    }



}
