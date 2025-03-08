package collections.arrays.linkedlist;

class DeleteNodeWithoutHead {

    // Function to delete the given node (without having access to head)
    public void deleteNode(Node node) {
        // Check if the node is not null and is not the last node
        if (node == null || node.next == null) {
            System.out.println("Can't delete this node (node is null or last node).");
            return;
        }

        // Copy the data from the next node to the current node
        node.data = node.next.data;

        // Point the current node to the next of the next node (i.e., skip the next node)
        node.next = node.next.next;
    }

    // Function to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating the linked list
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        // Printing the original list
        DeleteNodeWithoutHead list = new DeleteNodeWithoutHead();
        System.out.println("Original Linked List:");
        list.printList(head);

        // Deleting the node with value 30 (we have the reference to the node with value 30)
        Node nodeToDelete = head.next.next;  // node with value 30
        list.deleteNode(nodeToDelete);

        // Printing the modified list after deletion
        System.out.println("Linked List after deleting the node with value 30:");
        list.printList(head);
    }
}

