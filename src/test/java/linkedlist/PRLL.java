package linkedlist;

public class PRLL {
    public static void main(String[] args) {
        Node headNode = new Node(0);
        headNode.next = new Node(1);
        headNode.next.next = new Node(2);
        Node reversedNode = reverseLL(headNode);
        printNode(reversedNode);
    }

    private static void printNode(Node node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    private static Node reverseLL(Node node) {
        Node prev = null;
        while (node != null) {
            Node temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}
