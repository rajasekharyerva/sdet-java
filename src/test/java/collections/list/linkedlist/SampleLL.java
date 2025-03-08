package collections.arrays.linkedlist;
import  java.util.LinkedList;

public class SampleLL {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        // add
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        // remove
        System.out.println(linkedList.remove());

        // removeFirst
        System.out.println(linkedList.poll());
        System.out.println("------");
        linkedList.removeFirst();

        // print
        linkedList.forEach(System.out::println);

        // addFirst
        linkedList.addFirst(5);
        linkedList.forEach(System.out::println);
    }
}
