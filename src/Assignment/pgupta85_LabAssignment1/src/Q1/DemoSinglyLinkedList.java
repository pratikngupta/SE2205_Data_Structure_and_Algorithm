/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 8th October
 * Task: Work with ArrayList, LinkedList and Queue
 What will this code do?
 1) This code will initialize integer and string type Arraylist
 2) This code will initialize integer and string type LinkedList using SinglyLinkedList class
 3) Then this will call stackDemo method to demonstrate stack operation
 4) Then this will call queueDemo method to demonstrate queue operation
 5) This will then ask user to find number in the list using searchStack method
 *************************************************************************************************************************/
package Assignment.pgupta85_LabAssignment1.src.Q1;

import java.util.*; //Importing all classes from java.util package to use ArrayList class

import static Assignment.pgupta85_LabAssignment1.src.Method.Ask.*; //Importing all static methods from Method.Ask class

public class DemoSinglyLinkedList {

    //Creating static methods call myHeader which will accept integers and string as formal parameters
    public static void myHeader(int labNumber,int qNumber, String message){
        //Using printf to print and format message, %d will help to print integers variable
        System.out.printf(blue + """
                ===============================================================================
                Lab Exercise %d
                Question Number %d
                Prepared by: Pratik Narendra Gupta
                Student Number: 251211859
                Goal of this exercise: %s\040
                ===============================================================================
                """ + reset, labNumber, qNumber, message);
    }

    //Creating static methods call myFooter which will accept integers as formal parameters
    public static void myFooter(int labNumber,int qNumber) {
        //Using printf to print and format message, %d will help to print integers variable
        System.out.printf(blue + """
                ===============================================================================
                Completion of lab %d, Question %d was successful
                Signing off Pratik
                ===============================================================================
                """ + reset, labNumber, qNumber);
        System.exit(0);
    }

    //creating stackDemo Method, with SinglyLinkList<integers> type parameter,
    public static void stackDemo(SinglyLinkList <Integer> stack) {

        int result; //declaring variable to store result
        System.out.println(green + "Stack demo With the Integers linked List\n" + reset);
        System.out.println("Which end of the Linked List you would like to use as the stack top?");

        result = getInt("Enter 1 for head or 2 for tail", 1); //Using getInt method from Ask class. opt 1 will make sure that user enter only int.
        //ASk user to enter 1 for head or 2 for Tail.

        //if user did not enter required value then it will ask user to enter again until user enter correct value
        while (result != 1 && result != 2) {
            System.out.println(red + "Please enter either 1 or 2" + reset);
            result = getInt("Enter 1 for head or 2 for tail", 1); //Using getInt method from Ask class. opt 1 will make sure that user enter only int
        }

        //using switch case to check which end of the linked list user want to use as stack top
        switch (result) {
            //if user enter 1 then it will use head as stack top
            case 1 -> {
                System.out.println(purple + "\nStack Top: Head of the linked list\n");
                System.out.println("Let's pop all the elements from the stack in sequence:" + reset);
                System.out.println(blue + "Current Stack: " + stack + reset);

                //using while loop to pop all the element from the stack
                while (!stack.isEmpty()) {
                    //using pop method to pop element from the head of the linked list
                    System.out.printf("%d has been popped! The revise stack is: %s\n", stack.popFromHead(), stack);
                }
                //Put back elements in the stack
                System.out.println(purple + "\nLet's push 39 and -58 in the stack .... " );
                System.out.printf(blue + "The current Stack is: %s\n", stack + reset);
                stack.pushAtHead(39);
                System.out.printf("After 39 is pushed, the revised Stack is: %s\n", stack);
                stack.pushAtHead(-58);
                System.out.printf("After 39 is pushed, the revised Stack is: %s\n", stack);

            }
            //if user enter 2 then it will use tail as stack top
            case 2 -> {
                System.out.println(purple + "\nStack Top: Head of the linked list\n" + reset);
                System.out.println(purple + "Let's pop all first three elements from the stack in sequence:" );
                System.out.println(blue + "Current Stack: " + stack + reset);

                //using while loop to pop two the element from the stack
                while (stack.getSize() > 2) {
                    //using popFromTail method to pop element from tail of the linked list
                    System.out.printf("%d has been popped! The revise stack is: %s\n", stack.popFromTail(), stack);
                }
                System.out.println(purple + "\nLet's push 39 and -58 in the stack .... " );
                System.out.printf(blue + "The current Stack is: %s\n", stack + reset);
                //using pushAtTail method to push element at tail of the linked list
                stack.pushAtTail(39);
                System.out.printf("After 39 is pushed, the revised Stack is: %s\n", stack);
                stack.pushAtTail(-58);
                System.out.printf("After 39 is pushed, the revised Stack is: %s\n", stack);
            }

        }
    }

    //creating queueDemo Method, with SinglyLinkList <String> type parameter,
    public static void queueDemo(SinglyLinkList <String> queue){


        System.out.println(green + "\nQueue demo With the String linked List" + reset);
        System.out.println("Note: Head is the Q-front, and Tail is the Q-rear\n");

        System.out.println(purple + "Let's dequeue all the elements from the queue in sequence:" + reset);

        //using enqueue method to add element at the tail of the linked list
        System.out.println( blue + "Current Queue: " + queue + reset);
        queue.enqueueAtTail("Joelle");
        System.out.println("After Joelle is enqueued, the revised Queue: " + queue);
        queue.enqueueAtTail("Lukas");
        System.out.println("After Lukas is enqueued, the revised Queue: " + queue);

        System.out.println(purple + "\nLet's dequeue first three elements from the queue in sequence ...." + reset);
        System.out.println( blue + "Current Queue: " + queue + reset);

        //using while loop to dequeue three element from the queue
        for (int i =1; i<4; i++){
            //using dequeue method to dequeue element from the head of the linked list
            System.out.printf("After %s is enqueued, the revised Queue: %s\n" , queue.dequeueFromHead(), queue);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //Declaring variable
        int value;
        char option;

        //calling myHeader method to print header
        myHeader(5,1,"Demonstrate the use of a singly linked list to store a list of integers and strings");

        //Creating ArrayList of integers and String
        ArrayList<Integer> number = new ArrayList<>(Arrays.asList(56,-22,34,57,98));
        ArrayList<String> name = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));
        System.out.println("\nThe given Integer array: "+ number);
        System.out.println("The given String array: " + name);

        //Creating SinglyLinkList of integers
        SinglyLinkList<Integer> linkNumber = new SinglyLinkList<>();
        //pushing value to the linked list using addFirst and addLast method
        for (int i = 0; i < number.size() - 2; i++) {
            linkNumber.addFirst(number.get(i));
        }
        for (int i = number.size() - 1; i > 2; i--) {
            linkNumber.addLast(number.get(i));
        }

        System.out.println("\nYour Integers List: " + linkNumber);

        //Creating SinglyLinkList of String
        SinglyLinkList<String> linkName = new SinglyLinkList<>();
        //pushing value to the linked list using addFirst and addLast method
        for (int i = 0; i < name.size() - 2; i++) {
            linkName.addFirst(name.get(i));
        }
        for (int i = name.size() - 1; i > 2; i--) {
            linkName.addLast(name.get(i));
        }

        System.out.printf("Your String List: %s\n\n", linkName);

        //calling stackDemo method to demonstrate stack
        stackDemo(linkNumber);

        //calling queueDemo method to demonstrate queue
        queueDemo(linkName);

        //Using do/while loop to ask user to continue or not
        do {
            System.out.println(green + "\nlet Search the Stack..." );
            System.out.println(blue + "Current Stack: " + linkNumber + reset);

            //Asking user to enter value to search
            value = getInt("Enter the value you are searching for",1);

            //using if/else statement and searchStack Method to check if value is present or not
            if (linkNumber.searchStack(value) == -1) {
                System.out.println("The Value is not found!");
            }
            else {
                System.out.printf("The value: %d is found in location: %d from top of the stack \n", value,linkNumber.searchStack(value)+1);
            }
            //Asking user to continue or not
            option = getChar("Do you want to continue? (enter 'y' for yes or enter any other key to discontinue)",1);
        }
        while (option == 'Y');

        System.out.println();

        //Calling myFooter method to print footer
        myFooter(1,1);

    }
}
