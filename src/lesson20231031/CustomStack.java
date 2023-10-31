package lesson20231031;

public class CustomStack {

    private String[] data;

    private int count;

    public CustomStack(int capacity){
        data = new String[capacity];
        count = 0;
    }

    public void push(String element){
        if (count == data.length) throw new RuntimeException("Stack is full");
        // if (count == data.length) growSize() -- dynamic stack implementation
        data[count++] = element;
    }

    public String pop(){
        if (count == 0) throw new RuntimeException("Stack is empty");
        String element = data[count - 1];
        data[count - 1] = null;
        count--;
        return element;
    }

    public String peek(){
        if (count == 0) throw new RuntimeException("Stack is empty");
        return data[count - 1];
    }


    public static void main(String[] args) {
        CustomStack stack = new CustomStack(4);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }



}
