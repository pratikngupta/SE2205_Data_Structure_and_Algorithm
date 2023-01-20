/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 8th October
 * Task: Work with ArrayList, LinkedList and Queue
 What will this code do?
 1) it will help to create a Singly Linked List
 2) It will hold method required by the DemoSinglyLinkedList.java like:
 *************************************************************************************************************************/
package Assignment.pgupta85_LabAssignment1.src.Q1;

public class SinglyLinkList<T>{

    //Declaring private variables
    private Node<T> head;
    private Node<T> tail;
    private int size;


    //creating constructor with no parameters.

    public SinglyLinkList(){
        head = null;
        tail = null;
        size = 0;
    }

    //creating constructor with parameters.
    public SinglyLinkList(Node <T> head, Node <T> tail, int size){
        this.head = head;
        this.tail = tail;
        this.size = size;
    }


    //Getter method for field 'size'
    public int getSize(){
        return size;
    }

    //This will check the size of link list and if the list is empty it will return true.
    public boolean isEmpty(){
        return getSize() == 0;
    }

    //Overriding toString method to print the list.
    public String toString(){
        //Using StringBuilder to avoid creating new string object every time. and help to store result in one string.
        StringBuilder result = new StringBuilder("[");

        //Creating a reference variable to traverse the list.
        Node<T> current = head;

        //if the list is empty it will return empty list.
        if (current == null){
            result.append("[[");
        }
        //If not then it will use while loop to go through the list and add each element to the result.
        while (current != null){
            result.append(current.getElements()).append(", "); //`.append` will add the element to the result.
            current = current.getNext(); //`.getNext` will get the next element in the list.
        }

        //This will remove the last bracket and space from the result before returning it.
        return result + "\b\b]";
    }

    //This will add element to the front of the list.
    public void addFirst(T elements){
        //Creating a new node with the element passed.
        head = new Node<>(elements, head);
        //If the list was empty before adding the element, it will make the tail point to the new element.
        if (size == 0){
            tail = head;
        }
        //Increasing the size of the list.
        size++;
    }

    //This will add element to the end of the list.
    public void addLast(T elements){
        //Creating a new node with the element passed.
        Node<T> newest = new Node<>(elements, null);
        //If the list was empty before adding the element, it will make the head point to the new element.
        if (isEmpty()){
            head = newest;
        }
        //If the list was not empty, it will make the tail point to the new element.
        else {
            tail.setNext(newest);
        }
        //Making the tail point to the new element.
        tail = newest;
        //Increasing the size of the list.
        size++;
    }

    //This will remove the first element from the list.
    public T removeFirst(){
        //If the list is empty it will return null.
        if (isEmpty()){
            return null;
        }
        //Storing the element to be removed in a variable.
        T answer = head.getElements();
        //Making the head point to the next element in the list.
        head = head.getNext();
        //Decreasing the size of the list.
        size--;
        //If the list is empty after removing the element, it will make the tail point to null.
        if (size == 0){
            tail = null;
        }
        //Returning the element removed.
        return answer;
    }

    //This will remove the last element from the list.
    public T removeLast(){
        //If the list is empty it will return null.
        if (isEmpty()){
            return null;
        }
        //Storing the element to be removed in a variable.
        T answer = tail.getElements();
        if (size == 1){
            head = null;
            tail = null;
        }
        //If the list is not empty, it will use while loop to go through the list and make the second last element point to null.
        else {
            Node<T> current = head;
            while (current.getNext() != tail){
                current = current.getNext();
            }
            tail = current;
            tail.setNext(null);
        }
        //Decreasing the size of the list.
        size--;
        //Returning the element removed.
        return answer;
    }

    //This will add element to the list at the given index.
    public void pushAtHead(T elements){
        addFirst(elements);
    }

    //This will remove elements at the given index.
    public T popFromHead(){
        // Will return removed element
        return (removeFirst());
    }

    //It will add element to the list at the tail
    public void pushAtTail(T elements){
        addLast(elements);
    }

    //It will remove element from the list at the tail
    public T popFromTail(){
        return (removeLast());
    }

    //This will add element to the list at the tail.
    public void enqueueAtTail(T elements){
        addLast(elements);
    }

    //This will remove elements at head of the list.
    public T dequeueFromHead(){
        return (removeFirst());
    }

    //This will search for the given element in the list.
    public int searchStack(T elements){
        int index = 0;
        Node<T> current = head;
        while (current != null){
            if (current.getElements().equals(elements)){
                return index; //will return the index of the element if found.
            }
            current = current.getNext();
            index++;
        }
        return -1; //will return -1 is value is not found.
    }

}
