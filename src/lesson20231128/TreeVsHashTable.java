package lesson20231128;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TreeVsHashTable {

    public static void main(String[] args) {

        Map<Integer, String> tree = new TreeMap<>();
        Map<Integer, String> hashTable = new HashMap<>(8_000_000, 0.75f);
        Random random = new Random();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            tree.put(random.nextInt(20_000_000),"Value");
        }
        long end = System.currentTimeMillis();
        System.out.println("Time for tree: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            hashTable.put(random.nextInt(20_000_000),"Value");
        }
        end = System.currentTimeMillis();
        System.out.println("Time for hash table: " + (end - start));

    }


}
