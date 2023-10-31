package lesson20231031;

public class CustomStack {

    private Integer[] data;

    private int count;

    public CustomStack(int capacity){
        data = new Integer[capacity];
        count = 0;
    }

    public void push(Integer element){
        if (count == data.length) throw new RuntimeException("Stack is full");
        // if (count == data.length) growSize() -- dynamic stack implementation
        data[count++] = element;
    }

    public Integer pop(){
        if (count == 0) throw new RuntimeException("Stack is empty");
        Integer element = data[count - 1];
        data[count - 1] = null;
        count--;
        return element;
    }

    public Integer peek(){
        if (count == 0) throw new RuntimeException("Stack is empty");
        return data[count - 1];
    }


    public static void main(String[] args) {
        CustomStack stack = new CustomStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }



}
