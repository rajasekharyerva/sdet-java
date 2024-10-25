package sdet;

import java.util.Stack;

public class NextGreaterElement {
    public static void findNextGreaterElement(int[] arr) {
        // Create an array to store the next greater elements
        int n = arr.length;
        int[] nge = new int[n];

        // Create a stack to store the indices of the elements
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Check for the next greater element
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                nge[stack.pop()] = arr[i]; // Set NGE for popped element
            }
            // Push current index onto the stack
            stack.push(i);
        }

        // For remaining elements in the stack, set NGE as -1
        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }

        // Print the results
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " --> " + nge[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        findNextGreaterElement(arr);
    }
}

