package lesson20231212;

public class SumDivideAndConquer {

// 4 + 6 + 1 + 9 + 6 + 9 + 11 + 89 // O(n) 7 operations
// ((4 + 6) + (1 + 9)) + ((6 + 9) + (11 + 89)) // O(n)
// 4 parallel ---> 2 parallel ----> 1
// 3 sequentially operations  ----> O(log(n)) in parallel

    public static void main(String[] args) {
        System.out.println(sum(new int[] {2, 5, 8, 12, 10}));
    }

    public static int sum(int[] data) {
        return sumRecursive(data, 0, data.length - 1);
    }

    private static int sumRecursive(int[] data, int start, int end) {
        if (end == start) return data[start]; // base condition
        int middle = start + (end - start) / 2;
        return sumRecursive(data, start, middle) + sumRecursive(data, middle + 1, end);
    }

}
