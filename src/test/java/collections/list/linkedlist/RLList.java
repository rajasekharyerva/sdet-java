package collections.arrays.linkedlist;

public class RLList {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(4);
        head.next.next = new Node(9);
        Node result = rll(head);
        printll(result);
    }

    private static void printll(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
    }

    private static Node rll(Node node) {

        //7,4,9
        Node result = null;
        //result, result.next
        while (node != null) {
            Node temp = node.next;
            node.next = result;
            result = node;
            node = temp;
        }
        return result;
    }

}
