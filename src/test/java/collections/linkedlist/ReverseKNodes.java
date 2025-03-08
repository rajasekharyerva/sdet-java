package collections.arrays.linkedlist;


public class ReverseKNodes {

    // Function to reverse k nodes in a linked list
    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prevGroupEnd = dummy;
        Node current = head;

        while (current != null) {
            Node groupStart = current;
            Node groupEnd = current;

            // Find the k-th node in the group
            int count = 0;
            while (groupEnd != null && count < k - 1) {
                groupEnd = groupEnd.next;
                count++;
            }

            if (groupEnd == null) {
                // Reverse the remaining nodes (last group)
                prevGroupEnd.next = reverse(groupStart, null);
                break;
            }

            Node nextGroupStart = groupEnd.next;
            groupEnd.next = null; // Disconnect the group

            // Reverse the current group and connect it back to the list
            printList(groupStart);
            printList(prevGroupEnd);
            prevGroupEnd.next = reverse(groupStart, null);
            printList(groupStart);
            printList(prevGroupEnd);
            groupStart.next = nextGroupStart;

            // Update pointers for the next group
            prevGroupEnd = groupStart;
            current = nextGroupStart;
        }

        return dummy.next;
    }

    // Helper function to reverse a linked list
    private static Node reverse(Node head, Node newHead) {
        Node prev = newHead;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // Function to print a linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> faq2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);

        System.out.print("Original List: ");
        printList(head);

        int k = 4;
        head = reverseKGroup(head, k);

        System.out.print("Reversed List: ");
        printList(head);
    }


}
