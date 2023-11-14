package lesson20231107;

public class SimpleMain {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.pushToHead(25);
        myList.pushToHead(10);
        myList.pushToTail(18);
        myList.pushToIndex(2,14);
        System.out.println("Size = "+myList.size());
        myList.print();
    }
}
