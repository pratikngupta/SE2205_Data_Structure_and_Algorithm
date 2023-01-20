package Assignment.pgupta85_LabAssignment3.src;

/***********************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Date: 10/20/2020
 * Student ID: 251211859
 * Task: Sort the names and grades of students in ascending order of grades and descending order of names
 * What does the code do:
 * 1. This is master code
 * 2. It will call the code from the package Q1
 * 3. It will call the code from the package Q2
 **********************************************************************************************************************/


import Assignment.pgupta85_LabAssignment3.src.Q1.PratikDemoHashingWithLinearProbing;
import Assignment.pgupta85_LabAssignment3.src.Q2.PratikDemoHashingWithAllOpenAddressingTechniques;

import static Assignment.pgupta85_LabAssignment3.src.Method.Ask.*;
import static Assignment.pgupta85_LabAssignment3.src.Method.Intro.*;

public class master {
    public static void main(String[] args) {

        int choice;

        do {
            myHeader(3,1,"Pratik Gupta","Master");
            System.out.println(purple + "1. Linear Probing");
            System.out.println("2. All Open Addressing Techniques");
            System.out.println("3. Exit" +reset);
            choice = getInt("Enter your choice", 1);

            switch (choice) {
                case 1 -> PratikDemoHashingWithLinearProbing.main(args);
                case 2 -> PratikDemoHashingWithAllOpenAddressingTechniques.main(args);
                case 3 -> {
                    myFooter(3,1);
                    System.out.println("Thank you for using my program!");
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 3);
    }
    //Thank You are teaching me this course

}