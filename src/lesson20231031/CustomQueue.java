package lesson20231031;

public class CustomQueue {

    private int[] data;
    private int head;
    private int tail;

    public CustomQueue(int capacity){
        data = new int[capacity];
        head = -1;
        tail = -1;
    }

    public void enqueue(int element){ // TODO
        data[++tail] = element;
    }

    public int dequeue(){ // TODO
        return data[++head];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public int size() { // TODO
        return 0;
    }

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }


}
