package linkedlist;

public class LinkedListCycleSize {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int getLinkedListSize(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect cycle using Floyd's Cycle Detection Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                return countCycleSize(slow) + countNodesBeforeCycle(head, slow);
            }
        }

        // No cycle, count all nodes
        return countNodes(head);
    }

    private static int countCycleSize(Node meetingPoint) {
        Node current = meetingPoint;
        int count = 0;

        do {
            current = current.next;
            count++;
        } while (current != meetingPoint);

        return count;
    }

    private static int countNodesBeforeCycle(Node head, Node meetingPoint) {
        Node current = head;
        int count = 0;

        while (current != meetingPoint) {
            current = current.next;
            count++;
        }

        return count;
    }

    private static int countNodes(Node head) {
        int count = 0;
        Node current = head;

        while (current != null) {
            current = current.next;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        // Create a linked list with a cycle
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Create a cycle

        System.out.println("Size of the linked list: " + getLinkedListSize(head));
    }
}


