package Lab.pgupta85_LabExcercise3.src;

import  Lab.pgupta85_LabExcercise3.src.Q1.Drive_DoubleLinkedList;
import  Lab.pgupta85_LabExcercise3.src.Q2.DriverForStudentClass;
import static  Lab.pgupta85_LabExcercise3.src.Method.Intro.*;


public class Master {


    public static void main (String [] args) {

        int choice;

        do {
            myHeader(3,1,"Pratik Gupta","Master");
            System.out.println(purple + "1. Double Linked List");
            System.out.println("2. Comparable");
            System.out.println("3. Exit" +reset);
            choice = getInt("Enter your choice", 1);

            switch (choice) {
                case 1 -> Drive_DoubleLinkedList.main(args);
                case 2 -> DriverForStudentClass.main(args);
                case 3 -> {
                    myFooter(3,1);
                    System.out.println("Thank you for using my program!");
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 3);

    }


}
