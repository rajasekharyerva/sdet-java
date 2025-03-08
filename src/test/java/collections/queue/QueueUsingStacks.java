package collections.queue;

import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1; // Main collections.stack
    private Stack<Integer> stack2; // Auxiliary collections.stack

    // Constructor
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Method to add an item to the collections.queue
    public void enqueue(int item) {
        stack1.push(item);
    }

    // Method to remove and return the front item from the collections.queue
    public int dequeue() throws Exception {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return stack2.pop();
    }

    // Method to check if the collections.queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        try {
            QueueUsingStacks queue = new QueueUsingStacks();

            // Enqueue elements
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);

            // Dequeue elements
            System.out.println("Dequeued: " + queue.dequeue()); // Output: 10
            System.out.println("Dequeued: " + queue.dequeue()); // Output: 20

            // Enqueue more elements
            queue.enqueue(40);
            queue.enqueue(50);

            // Dequeue remaining elements
            System.out.println("Dequeued: " + queue.dequeue()); // Output: 30
            System.out.println("Dequeued: " + queue.dequeue()); // Output: 40
            System.out.println("Dequeued: " + queue.dequeue()); // Output: 50

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

