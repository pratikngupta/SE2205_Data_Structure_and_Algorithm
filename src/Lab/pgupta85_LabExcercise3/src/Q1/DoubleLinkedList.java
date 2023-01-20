/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 18th October
 * Task: Work with DLL
 What will this code do?
 1) it will help to create a Double Linked List
 2) It will hold method required by the Drive_doubleLinkedList.java like:
 3) It will help to add, remove, get, set, and print the list.
 *************************************************************************************************************************/
package Lab.pgupta85_LabExcercise3.src.Q1;

public class DoubleLinkedList <E>{

    private final Node<E> head;
    private final Node<E> tail;
    private int size = 0;

    public DoubleLinkedList() {
        head = new Node<>(null, null, null); // create header
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        addBetween(e, tail.getPrev(), tail);
    }

    public void addBetween(E e, Node<E> predecessor, Node<E> successor) { // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

   public Node<E> findNode(E element) {
        Node<E> current = head.getNext();
        while (current != tail) {
            if (current.getElement().equals(element)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

     public String toString() {
        StringBuilder result = new StringBuilder("(");
        Node<E> current = head.getNext();
        while (current != tail) {
            result.append(current.getElement());
            current = current.getNext();
            if (current != tail)
                result.append(", ");
        }
        return result.append(")").toString();
    }

}
