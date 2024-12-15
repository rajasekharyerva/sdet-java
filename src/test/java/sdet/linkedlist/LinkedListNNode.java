package sdet.linkedlist;

class LinkedListNNode {
    Node head; // Head of the list


    // Constructor to directly initialize the list
    public LinkedListNNode(int[] elements) {
        if (elements.length > 0) {
            head = new Node(elements[0]);
            Node current = head;
            for (int i = 1; i < elements.length; i++) {
                current.next = new Node(elements[i]);
                current = current.next;
            }
        }
    }

    // Method to find the nth node from the end
    public Node findNthFromEnd(int n) {
        Node first = head;
        Node second = head;

        // Move the first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first == null) {
                System.out.println("The list has fewer than " + n + " nodes.");
                return null;
            }
            first = first.next;
        }

        // Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    // Method to print the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Initialize the linked list with an array of values
        int[] elements = {1, 2, 3, 4, 5};
        LinkedListNNode list = new LinkedListNNode(elements);

        System.out.println("Original List:");
        list.printList();

        int n = 2;
        Node result = list.findNthFromEnd(n);
        if (result != null) {
            System.out.println("The " + n + "th node from the end is: " + result.data);
        }
    }
}
