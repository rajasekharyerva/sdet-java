package collections.queue;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a PriorityQueue to store elements with natural ordering (min-heap).
        PriorityQueue<Task> pq = new PriorityQueue<>();

        // Add tasks with priority.
        pq.add(new Task(2, "Task A"));
        pq.add(new Task(1, "Task B")); // Higher priority due to lower number
        pq.add(new Task(3, "Task C"));

        // Remove and display tasks based on priority.
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

// Task class implementing Comparable to define priority comparison.
class Task implements Comparable<Task> {
    private int priority;
    private String description;

    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    // Compare tasks based on priority (lower number = higher priority).
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task{" + "priority=" + priority + ", description='" + description + '\'' + '}';
    }
}

