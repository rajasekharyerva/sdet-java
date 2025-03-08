package collections.queue;

class QueueArray {
    private int[] queue;
    private int front, rear, capacity, size;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue element into the collections.queue
    public void enqueue(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }

    // Dequeue element from the collections.queue
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int dequeued = queue[front];
        front = (front + 1) % capacity;
        size--;
        return dequeued;
    }

    // Peek front element of the collections.queue
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    // Check if the collections.queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the collections.queue is full
    public boolean isFull() {
        return size == capacity;
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        
        QueueArray queue = new QueueArray(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();

        System.out.println("Front element: " + queue.peek()); // 10
        System.out.println("Dequeued: " + queue.dequeue());   // 10
        System.out.println("Dequeued: " + queue.dequeue());   // 20
    }
}
