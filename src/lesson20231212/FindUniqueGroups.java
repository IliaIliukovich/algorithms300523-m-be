package lesson20231212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindUniqueGroups {

    static final int MAX_CHAR = 26;

    public static void main(String[] args) {
        String[] words = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf", "tact"};
        wordsWithSameCharSet(words);
    }

    // Print all words together with same character sets.
    public static void wordsWithSameCharSet(String[] words) {
        int length = words.length;

        // Stores indexes of all words that have same set of unique characters
        Map<String, ArrayList<Integer>> map = new HashMap<>();

        // Алгоритм:
        // Перебрать все слова
        // если ключ уже есть, получите соответствующее значение, обновите список и добавьте в хэш
        // если ключа нет, создайте новый список и добавьте ключ и список в хэш

        for (int i = 0; i < length; i++) { // O(n)
            String key = getKey(words[i]);

            // if the key is already in the map then get its corresponding value and update the list and put it in the map
            if (map.containsKey(key)) {
                ArrayList<Integer> checkList = map.get(key);
                checkList.add(i);
                map.put(key, checkList);
            } else { // if key is not present in the map then create a new list and add both key and the list
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(key, list);
            }
        }

        // print all words that have the same unique character set
        for (Map.Entry<String, ArrayList<Integer>> it : map.entrySet()) {
            ArrayList<Integer> get = it.getValue();
            for (Integer v : get) {
                System.out.print(words[v] + ", ");
            }

            System.out.println();
        }
    }

    // Generates a key from given string.
    // The key contains all unique characters of given string in sorted order consisting of only distinct elements.
    static String getKey(String str) { // O(1)
        boolean[] visited = new boolean[MAX_CHAR];
        Arrays.fill(visited, false);

        // store all unique characters of current word in key
        for (int i = 0; i < str.length(); i++) {
            visited[str.charAt(i) - 'a'] = true;
        }

        StringBuilder key = new StringBuilder();
        for (int i = 0; i < MAX_CHAR; i++) {
            if (visited[i]) {
                key.append((char) ('a' + i));
            }
        }

        return key.toString();
    }

}


