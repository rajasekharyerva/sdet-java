package collections.arrays.linkedlist;

public class AddNodeToLL {
    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(8);
        addNodeAt(head, 5, 7);

    }

    private static void addNodeAt(Node node, int oldValue, int newValue) {
        while (node != null) {
            if (node.data == oldValue) {
                Node newNode = new Node(newValue);
                newNode.next = node.next;
                node.next = newNode;
                return;
            }
            node = node.next;
        }
    }
}
