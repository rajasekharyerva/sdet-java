package collections.queue;

import java.util.NoSuchElementException;

public class Queue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    // Constructor to initialize the collections.queue
    public Queue(int capacity) {
        this.capacity = capacity;
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation to add an element to the collections.queue
    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue Overflow! Cannot enqueue " + value);
        } else {
            rear = (rear + 1) % capacity;  // Circular increment
            queueArray[rear] = value;
            size++;
            System.out.println("Enqueued " + value + " to the collections.queue.");
        }
    }

    // Dequeue operation to remove and return the front element from the collections.queue
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow! Cannot dequeue from an empty collections.queue.");
        } else {
            int dequeuedValue = queueArray[front];
            front = (front + 1) % capacity;  // Circular increment
            size--;
            System.out.println("Dequeued " + dequeuedValue + " from the collections.queue.");
            return dequeuedValue;
        }
    }

    // Peek operation to view the front element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty! Cannot peek.");
        }
        return queueArray[front];
    }

    // Check if the collections.queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check the size of the collections.queue
    public int size() {
        return size;
    }

    // Display collections.queue contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            int current = front;
            for (int i = 0; i < size; i++) {
                System.out.print(queueArray[current] + " ");
                current = (current + 1) % capacity;  // Circular increment
            }
            System.out.println();
        }
    }

    // Main method for testing the collections.queue operations
    public static void main(String[] args) {
        Queue queue = new Queue(5);  // Queue with a capacity of 5

        // Enqueue elements to the collections.queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Display the collections.queue contents
        queue.display();

        // Enqueue when the collections.queue is full (Overflow)
        queue.enqueue(60);

        // Dequeue elements from the collections.queue
        queue.dequeue();
        queue.dequeue();

        // Display the collections.queue contents after dequeue operations
        queue.display();

        // Peek the front element
        System.out.println("Front element is: " + queue.peek());

        // Dequeue all elements
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        // Display the collections.queue after all dequeues
        queue.display();

        // Dequeue from empty collections.queue (Exception)
        try {
            queue.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

