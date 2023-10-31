package lesson20231031;

public class SpecialStack {

    // Реализовать структуру данных SpecialStack, которая поддерживает все операции со стеком,
    // такие как push(), pop(), isEmpty(), и дополнительную операцию getMin(),
    // которая должна возвращать минимальный элемент из SpecialStack.
    //Все эти операции SpecialStack должны быть O(1). Пространство O(n)

    private CustomStack customStack;
    private CustomStack currentMin;

    public SpecialStack(int capacity) {
        customStack = new CustomStack(capacity);
        currentMin = new CustomStack(capacity);
    }

    public void push(Integer element){ // O(1)
        if (isEmpty()) {
            currentMin.push(element);
        } else {
            int minStored = currentMin.peek();
            currentMin.push(Math.min(minStored, element));
        }
        customStack.push(element);
    }

    public Integer pop(){ // O(1)
        Integer element = customStack.pop();
        currentMin.pop();
        return element;
    }

    public Integer getMin(){ // O(1)
        return currentMin.peek();
    }

    public boolean isEmpty(){
        return customStack.isEmpty();
    }

    public static void main(String[] args) {
        SpecialStack stack = new SpecialStack(5);
        stack.push(18);
        stack.push(19);
        stack.push(29);
        stack.push(15);
        stack.push(16);

        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

    }
}
