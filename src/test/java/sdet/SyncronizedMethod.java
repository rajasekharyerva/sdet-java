package sdet;

class Counter {
    private int count = 0;

    // Synchronized method to ensure thread safety
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class SyncronizedMethod {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Creating two threads to increment the counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                System.out.println("Thread 1: " + counter.getCount());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                System.out.println("Thread faq2: " + counter.getCount());
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount()); // Should be 2000
    }
}
