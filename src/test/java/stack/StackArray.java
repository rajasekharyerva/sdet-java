package stack;

public class StackArray {
    int[] stack;
    int top;
    int capacity;

    StackArray(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    public static void main(String[] args) {

        StackArray stack = new StackArray(5);
        stack.push(1);
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    private void push(int data) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++top] = data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    private int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        //return true if top value equals -1
        return top == -1;
    }
}
