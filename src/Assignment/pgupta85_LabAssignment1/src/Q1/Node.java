/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 8th October
 * Task: Work with ArrayList, LinkedList and Queue
 What will this code do?
1) it will help to create a Singly Linked List
2) Creating a Node class to realise the list.

 *************************************************************************************************************************/
package Assignment.pgupta85_LabAssignment1.src.Q1;

public class Node <T> {

    //Creating private variables
    private T elements;
    private Node<T> next;

    //Creating constructor with no parameters
    public Node() {
    }

    //Creating constructor with parameters
    public Node (T elements, Node<T> next) {
        this.elements = elements;
        this.next = next;
    }

    //getter method for next
    public Node<T> getNext() {
        return next;
    }

    //getter method for elements
    public T getElements() {
        return elements;
    }

    //setter method for next
    public void setNext(Node<T> next) {
        this.next = next;
    }


}

