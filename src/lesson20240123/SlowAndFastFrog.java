package lesson20240123;


public class SlowAndFastFrog {


    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    // Имеется связанный список и целое число N,
    // задача состоит в том, чтобы удалить N-й узел с конца данного связанного списка.
        public static void main(String[] args) {
            Node node5 = new Node(5, null);
            Node node4 = new Node(4, node5);
            Node node3 = new Node(3, node4);
            Node node2 = new Node(2, node3);
            Node node1 = new Node(1, node2);

            Node first = node1;
            System.out.println("Initial list:");
            printList(first);

            removeNodeFromEnd(first, 2);
            System.out.println("Final list:");
            printList(first);
        }

    public static void removeNodeFromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println("Found node to delete: " + slow.next.data);
        slow.next = slow.next.next;
    }

    public static void printList(Node first){
        Node current = first;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("\n");
    }

}
