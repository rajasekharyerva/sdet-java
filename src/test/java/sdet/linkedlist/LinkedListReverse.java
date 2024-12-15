package sdet.linkedlist;

class LinkedListReverse {

    Node head;

    // Method to add a new node at the end of the LinkedList
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to reverse the LinkedList
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;   // Store the next node
            current.next = prev;   // Reverse the current node's pointer
            prev = current;        // Move prev to current node
            current = next;        // Move to the next node in the list
        }
        head = prev;               // Set the new head to the last node
    }

    // Method to print the LinkedList
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListReverse list = new LinkedListReverse();

        // Adding nodes to the LinkedList
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);

        System.out.println("Original LinkedList:");
        list.printList();

        // Reversing the LinkedList
        list.reverse();

        System.out.println("Reversed LinkedList:");
        list.printList();
    }
}

