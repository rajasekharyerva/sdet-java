package collections.arrays.linkedlist;

public class LinkedListIntersection {
    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node pointerA = headA;
        Node pointerB = headB;

        // Traverse both lists, switching heads when reaching the end
        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA; // Either the intersection point or null
    }

    public static void main(String[] args) {
        // Example setup
        Node common = new Node(8);
        common.next = new Node(10);

        Node headA = new Node(3);
        headA.next = new Node(6);
        headA.next.next = common;

        Node headB = new Node(4);
        headB.next = common;

        Node intersection = getIntersectionNode(headA, headB);
        System.out.println(intersection != null ? "Intersection at: " + intersection.data : "No intersection");
    }
}


