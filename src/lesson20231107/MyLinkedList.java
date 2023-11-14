package lesson20231107;

public class MyLinkedList {

    private Node head;

    public void pushToHead(int data) {
        Node newNode = new Node(data);
        //Is empty, then make the new node as head
        if (head == null) {
            head = newNode;
            return;
        }
        //Make next of new Node as head
        newNode.setNext(head);
        //Move the head to point to new Node
        head = newNode;
    }

    public void pushToTail(int data) {
        Node newNode = new Node(data);
        //Is empty, then make the new node as head
        if (head == null) {
            head = newNode;
            return;
        }

        //Else traverse till the last node
        Node last = head;
        while (last.getNext() != null) {
            last = last.getNext();
        }

        // Change the next of last node
        last.setNext(newNode);
    }

    public boolean pushToIndex(int index, int data) {
        Node newNode = new Node(data);
        Node current = head;
        int jump;

        if (index < 1) {
            System.out.println("index out of bounds");
            return false;
        } else {
            jump = 0;
            while (jump < index - 1) {
                current = current.getNext();
                jump++;
            }

            newNode.setNext(current.getNext());
            current.setNext(newNode);

            return true;
        }

    }

    public boolean removeFirst() {
        if (head == null) {
            return false;
        }

        Node temp = head;
        head = head.getNext();
        temp.setNext(null);

        return true;
    }


    public boolean remove(int index) {
        Node current = head;
        int jump;
        if (index < 1) {
            System.out.println("index out of bounds");
            return false;
        } else {
            jump = 0;
            while (jump < index - 1) {
                current = current.getNext();
                jump++;
            }
            current.setNext(current.getNext().getNext());
            return true;
        }

    }

    public int get(int index) { // TODO
        return -1;
    }

    public boolean removeLast() { // TODO
        return false;
    }

    public boolean contains(int data) { // TODO
        return false;
    }

    public int size() { // O(n)
        Node node;
        int size = 0;
        for (node = head; node != null; node = node.getNext()) {
            size++;
        }
        return size;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
    }

}
