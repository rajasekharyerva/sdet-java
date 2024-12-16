package sdet.stack;

import java.util.EmptyStackException;

public class Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    // Constructor to initialize stack
    public Stack(int capacity) {
        this.capacity = capacity;
        stackArray = new int[capacity];
        top = -1; // Initially the stack is empty
    }

    // Push operation to add an element to the stack
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Cannot push " + value);
        } else {
            stackArray[++top] = value; // Increment top and add value to stack
            System.out.println("Pushed " + value + " to stack.");
        }
    }

    // Pop operation to remove the top element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throw exception if stack is empty
        } else {
            int poppedValue = stackArray[top--]; // Retrieve value and decrement top
            System.out.println("Popped " + poppedValue + " from stack.");
            return poppedValue;
        }
    }

    // Peek operation to view the top element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throw exception if stack is empty
        }
        return stackArray[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check the size of the stack
    public int size() {
        return top + 1;
    }

    // Display stack contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method for testing the stack operations
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Stack with capacity of 5

        // Pushing elements to the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Displaying stack contents
        stack.display();

        // Pushing when stack is full (Overflow)
        stack.push(60);

        // Popping elements from the stack
        stack.pop();
        stack.pop();

        // Displaying stack contents after pop operations
        stack.display();

        // Peek the top element
        System.out.println("Top element is: " + stack.peek());

        // Pop all elements
        stack.pop();
        stack.pop();
        stack.pop();

        // Display stack after all pops
        stack.display();

        // Pop from empty stack (Exception)
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

