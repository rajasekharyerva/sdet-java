package arrays;

import java.util.Stack;
import java.util.HashMap;

public class NextGreaterElement2 {
    public static void findNextGreaterElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> ngeMap = new HashMap<>();

        // Traverse the array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // Remove elements from the collections.stack that are smaller than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If collections.stack is empty, there is no greater element to the right
            int nextGreater = stack.isEmpty() ? -1 : stack.peek();
            ngeMap.put(arr[i], nextGreater);

            // Push the current element onto the collections.stack
            stack.push(arr[i]);
        }

        // Print the Next Greater Element for each input element
        for (int element : arr) {
            System.out.println(element + " -> " + ngeMap.get(element));
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        findNextGreaterElements(arr);
    }
}

