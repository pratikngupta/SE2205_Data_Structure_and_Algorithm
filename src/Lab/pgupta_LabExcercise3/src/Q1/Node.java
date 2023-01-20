/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 18th October
 * Task: Work with DLL
 What will this code do?
    1) it will help to create a Double Linked List
    2) Contains Node required by DLL
 *************************************************************************************************************************/

package Q1;

public class Node<E> {

    private final E element;
    private Node<E> next;
    private Node<E> prev;

    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setPrev(Node<E> p) {
        prev = p;
    }

    public void setNext(Node<E> n) {
        next = n;
    }
}
