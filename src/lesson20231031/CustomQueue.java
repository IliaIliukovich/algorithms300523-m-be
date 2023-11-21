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

    public void enqueue(int element){
        if (++tail >= data.length) tail = 0;
        if (tail == head) throw new RuntimeException("Queue is full");
        if (head == -1) head = 0;
        data[tail] = element;
    }

    public int dequeue(){
        if (head == -1) throw new RuntimeException("Queue is empty");
        int result = data[head];
        if (head == tail) {
            head = -1;
            tail = -1;
        } else if (++head >= data.length) head = 0;
        return result;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public int size() { // TODO
        return 0;
    }

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(5);
        // Test 1
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

        // Test 2
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());

        // Test 3
        queue.enqueue(9);
        queue.enqueue(10);
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
    }

}
