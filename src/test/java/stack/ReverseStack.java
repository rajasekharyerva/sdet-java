package stack;

import java.util.Stack;

public class ReverseStack {
    // Function to reverse the stack
    public static void reverseStack(Stack<Integer> stack) {
        // Base case: if stack is empty
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Remove the top element
        int topElement = stack.pop();
        System.out.println("Remove the top element: " + topElement);

        // Step 2: Recursively reverse the remaining stack
        reverseStack(stack);

        // Step 3: Insert the removed element at the bottom
        insertAtBottom(stack, topElement);
    }

    // Function to insert an element at the bottom of the stack
    private static void insertAtBottom(Stack<Integer> stack, int element) {
        // Base case: if stack is empty, push the element
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        // Step 1: Remove the top element
        int topElement = stack.pop();

        // Step 2: Recursive call to insert element at the bottom
        insertAtBottom(stack, element);

        // Step 3: Push the removed element back to stack
        stack.push(topElement);
    }

    // Driver function
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Input example
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original Stack: " + stack);

        // Reverse the stack
        reverseStack(stack);

        System.out.println("Reversed Stack: " + stack);
    }
}

