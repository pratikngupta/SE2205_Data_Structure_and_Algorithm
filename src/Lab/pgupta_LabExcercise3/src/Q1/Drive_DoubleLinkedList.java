/*************************************************************************************************************************
        * Name: Pratik Narendra Gupta
        * Student ID: 251211859
        * Date: 8th October
        * Task: Work with DLL
        What will this code do?
        1) This is the main class which will create the list and call the methods from the SinglyLinkList.java
        2) It will create arraylist of MyStudent
        3) Then we will create a link list of MyStudent
        4) We will print out the list
        5) We will use addBetween method to add a new element in the list
        6) We will print out revise List
 *************************************************************************************************************************/
package Q1;

import static Method.Intro.*; //importing all the methods from the Intro.java and its parent class, Ask.java

public class Drive_DoubleLinkedList {

    public static void main(String[] args) {
        myHeader(3, 1, "Pratik Gupta","Working with Double Linked List");

        DoubleLinkedList<MyStudent> studentList = new DoubleLinkedList<>();

        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry", 67.35);
        MyStudent s2 = new MyStudent("Luna", 87.5);
        MyStudent s3 = new MyStudent("Vincent", 60.5);
        MyStudent s4 = new MyStudent("Hermione", 89.2);

        studentList.addLast(s0);
        studentList.addLast(s1);
        studentList.addLast(s2);
        studentList.addLast(s3);

        System.out.println("Adding 4 student in list\nThe list contains: ");
        System.out.println(purple + studentList + reset);

        System.out.println("Adding Hermione to the list in between Luna and Vincent.....");

        studentList.addBetween(s4, studentList.findNode(s2), studentList.findNode(s3));
        System.out.println("The list contains: ");
        System.out.println(purple + studentList + reset);

        myFooter(3, 1);
    }

}
