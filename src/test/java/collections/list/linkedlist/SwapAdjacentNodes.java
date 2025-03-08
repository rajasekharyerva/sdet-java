package collections.arrays.linkedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SwapAdjacentNodes {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node and set it as the previous node to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNode = dummy;

        // Traverse the list in pairs and swap nodes
        while (head != null && head.next != null) {
            // Identify the two nodes to swap
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Perform the swap
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Move the prevNode and head pointers for the next pair
            prevNode = firstNode;
            head = firstNode.next;
        }

        // Return the new head, which is the second node of the first pair
        return dummy.next;
    }

    // Helper function to print the linked list
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> faq2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        SwapAdjacentNodes solution = new SwapAdjacentNodes();

        System.out.println("Original list:");
        solution.printList(head);

        // Perform the swap
        ListNode swappedHead = solution.swapPairs(head);

        System.out.println("After swapping pairs:");
        solution.printList(swappedHead);
    }
}
