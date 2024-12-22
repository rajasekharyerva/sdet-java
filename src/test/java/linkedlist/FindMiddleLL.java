package linkedlist;

public class FindMiddleLL {
    static Node head = null;

    public static void main(String[] args) {
        addToLL(1);
        addToLL(2);
        addToLL(3);
        addToLL(4);
        printLL(head);
        findMiddle(head);
        System.out.println(findMiddleSlowFast(head));
    }

    private static int findMiddleSlowFast(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    private static void printLL(Node node) {
        while (node != null) {
            node = node.next;
        }
    }

    private static void addToLL(int value) {
        if (head == null)
            head = new Node(value);
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
    }

    private static int findMiddle(Node node) {
        int size = 0;
        Node returnNode = node;
        while (node != null) {
            node = node.next;
            size++;
        }
        int returnIndex = size / 2;
        int i = 0;
        while (i < returnIndex) {
            returnNode = returnNode.next;
            i++;
        }
        return returnNode.data;
    }
}
