package lesson20231024;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CustomDynamicArray {

    private int[] data;
    private int size;
    private int count;

    public CustomDynamicArray(){
        data = new int[1];
        size = 1;
        count = 0;
    }

    public CustomDynamicArray(int capacity){
        data = new int[capacity];
        size = capacity;
        count = 0;
    }

    public void add(int element){
        if (count >= size) {
            growSize();
        }
        data[count++] = element;
    }

    public void addAt(int index, int element) {
        if (index >= count) throw new IndexOutOfBoundsException("Input index is out of bounds");
        if (count >= size) {
            growSize();
        }
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        count++;
    }

    public void remove(){
        if (count == 0) throw new NoSuchElementException();
        data[count - 1] = 0; // data[count - 1] = null - necessary in case of objects for Garbage Collector
        count--;
//        shrinkSize();
    }

    public void removeAt(int index){ // TODO

    }

    public void shrinkSize() { //TODO

    }

    public void set(int index, int data){ //TODO

    }

    public int get(int index){ // TODO
        return 0;
    }

    public void clear(){ // TODO

    }

    public boolean contains(int data){
        return false; // TODO
    }

    public boolean isEmpty(){
        return false; // TODO
    }


    private void growSize() {
        int[] newData = new int[2 * size];
        for (int i = 0; i < count; i++) {
            newData[i] = data[i];
        }
        data = newData;
        size = 2 * size;
    }


    public static void main(String[] args) {
        CustomDynamicArray array = new CustomDynamicArray();
        array.add(1);
        System.out.println(array);
        array.printInnerStructure();

        array.add(2);
        System.out.println(array);
        array.printInnerStructure();

        array.add(3);
        System.out.println(array);
        array.printInnerStructure();

        array.add(4);
        System.out.println(array);
        array.printInnerStructure();

        array.add(5);
        System.out.println(array);
        array.printInnerStructure();

        array.addAt(0, 10);
        System.out.println(array);
        array.printInnerStructure();

        array.remove();
        System.out.println(array);
        array.printInnerStructure();
    }

    @Override
    public String toString(){
        return "[" + Arrays.stream(data).limit(count).boxed()
                .map(Object::toString).reduce((s1, s2) -> s1 + ", " + s2)
                .orElse("") + "]";
    }

    public void printInnerStructure(){
        System.out.println("Inner Structure: " + Arrays.toString(data));
    }


}
