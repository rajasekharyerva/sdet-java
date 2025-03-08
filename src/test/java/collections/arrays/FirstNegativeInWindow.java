package collections.arrays;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FirstNegativeInWindow {
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 4, -5, 6, -8, 5, -6};
        int N = 3;
        List<Integer> result = firstNegativeInEachWindow(arr, N);
        System.out.println(result); // Expected Output: [-1, -5, -8]
    }

    public static List<Integer> firstNegativeInEachWindow(int[] arr, int N) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // Store indices of negative numbers

        for (int i = 0; i < arr.length; i++) {
            // Add current index to deque if it's a negative number
            if (arr[i] < 0) {
                deque.offer(i);
            }

            // Remove indices outside the current window
            if (!deque.isEmpty() && deque.peek() < i - N + 1) {
                deque.poll();
            }

            // Add the result only at the end of each window
            if ((i + 1) % N == 0) { // Process only for each window end
                if (!deque.isEmpty()) {
                    result.add(arr[deque.peek()]); // Add the first negative number in the window
                } else {
                    result.add(0); // No negative number in the current window
                }
            }
        }

        return result;
    }
}
