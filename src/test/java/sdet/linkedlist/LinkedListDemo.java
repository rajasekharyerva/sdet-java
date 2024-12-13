package sdet.linkedlist;

class LinkedList {
    Node head;

    // Method to insert a interview19.txt node at the end
    public void insert(int data) {
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

    // Method to display the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to sort the linked list (using Bubble Sort)
    public void sort() {
        if (head == null || head.next == null) return; // No sorting needed for empty or single node list

        Node current = head;
        Node index = null;
        int temp;

        // Bubble sort for linked list
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.data > index.data) {
                    // Swap data of current and index nodes
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting nodes
        list.insert(30);
        list.insert(10);
        list.insert(50);
        list.insert(20);

        System.out.println("Original Linked List:");
        list.display();

        // Sorting the linked list
        list.sort();

        System.out.println("Sorted Linked List:");
        list.display();
    }
}


