/* You are given a node that is the beginning of a linked list. This list contains a dangling piece and a loop. Your objective is to determine the length of the loop.

        For example in the following picture the size of the dangling piece is 3 and the loop size is 12:


// Use the `getNext()` method to get the following node.
        node.getNext()
*/


import java.util.LinkedList;

public class GetTheLoop {
    public static void main(String[] args) {

        LinkedList<String> myLL = new LinkedList<String>();

        Node<String> node1 = new Node<>(null, "first", null);
        Node<String> node2 = new Node<>(node1, "second", null);

        Node<String> node3 = new Node<>(null, "first", node2);


        node1.item = "first";

        node2 = null;
        node2.item = "first2";

       // Node<String> node3 = null;
        node3.item = "first3";


       // loopSize(myLL.getFirst());

    }

    public static <E> int loopSize(Node node) {





        System.out.println(node);
        System.out.println(node.getNext());
        System.out.println(node.getNext().getNext());


        return 1;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
        Node getNext() {
            return this.next;
        }
    }

}
