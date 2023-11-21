package lesson20231114;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SearchTree {

    private class Node {
        private String key;
        private Integer value;

//        List<Node> nodes;
        private Node left;
        private Node right;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public SearchTree() {
        root = null;
    }

    // O(log(n)) if tree is balanced
    // compareTo() must be consistent with equals()
    public Integer find(String key) {
        Node tmp = root;
        while (tmp != null) {
            if (key.compareTo(tmp.key) == 0) return tmp.value;
            else if (key.compareTo(tmp.key) < 0) tmp = tmp.left;
            else if (key.compareTo(tmp.key) > 0) tmp = tmp.right;
        }
        return null;
    }

    // O(log(n)) if tree is balanced
    public void add(String key, Integer value) {
        root = add(root, key, value);
    }

    private Node add(Node node, String key, Integer value) {
        if (node == null) return new Node(key, value); // base condition

        if (key.compareTo(node.key) == 0) {
            node.value = value;
            return node;
        }
        if (key.compareTo(node.key) < 0) node.left = add(node.left, key, value);
        if (key.compareTo(node.key) > 0) node.right = add(node.right, key, value);
        return node;
    }

    // O(n)
    public Iterable<String> getKeys(){
        Queue<String> queue = new LinkedList<>();
        inorder(queue, root);
        return queue;
    }

    private void inorder(Queue<String> queue, Node node) {
        if (node == null) return; // base condition
        inorder(queue, node.left);
        queue.add(node.key);
        inorder(queue, node.right);
    }

    public String findByValueDFS(int value) { // O(n)
        return findByValueDFS(root, value);
    }

    private String findByValueDFS(Node current, int value) {
        if (current == null) return null;
        if (current.value == value) return current.key;
        String result = findByValueDFS(current.left, value);
        if (result == null) result = findByValueDFS(current.right, value);
        return result;
    }

    public String findByValueBFS(int value) { // O(n)
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.remove();
            if (current.value == value) return current.key;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return null;
    }

    // O(n*log(n) + n) = O(nlog(n))
    public static Iterable<String> sortWithTree(String[] data) {
        SearchTree searchTree = new SearchTree();
        for (int i = 0; i < data.length; i++) { // O(n)
            searchTree.add(data[i], 0); // O(log(n))
        }
        Iterable<String> sortedData = searchTree.getKeys(); // O(n)
        return sortedData;
    }

    public static void main(String[] args) {
        SearchTree tree = new SearchTree();
        tree.add("C", 10);
        tree.add("A", 5);
        tree.add("B", 2);
        tree.add("F", 100);
        tree.add("K", 100);
        tree.add("X", 100);

        System.out.println(tree.find("A"));
        System.out.println(tree.find("B"));
        System.out.println(tree.find("C"));
        System.out.println(tree.find("D"));

        System.out.println(tree.getKeys());

        // compareTo() must be consistent with equals()!
        // Tree - compareTo()
        // add(cat1)
        // add(cat2)
        // add(cat3)
        // add(cat4) ----> cat4

        // HashTable - equals() and hashCode()
        // add(cat1)
        // add(cat2)
        // add(cat3)
        // add(cat4)  ----> cat1, cat2, cat3, cat4

        System.out.println("Key by value, DFS: " + tree.findByValueDFS(2));
        System.out.println("Key by value, BFS: " + tree.findByValueBFS(2));

        String[] data = {"C", "D", "B", "A", "F", "E"};
        System.out.println("Input: " + Arrays.toString(data));
        Iterable<String> sortedData = sortWithTree(data);
        System.out.println("Output: " + sortedData);
    }
}
