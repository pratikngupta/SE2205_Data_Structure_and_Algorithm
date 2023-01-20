/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 18th October
 * Task: Work with interfaces and Collections
 What will this code do?
    1) Driver Method
    2) It will create a list of student object
    3) It will sort the list using Collections. Sort method
    4) It will print the list
 *************************************************************************************************************************/

package Lab.pgupta85_LabExcercise3.src.Q2;

import java.util.ArrayList; //importing ArrayList
import java.util.Collections; //importing Collections

import static  Lab.pgupta85_LabExcercise3.src.Method.Intro.*; //importing Intro class and its parent class, Ask.java

public class DriverForStudentClass {

    public static void main(String[] args) {

        ArrayList<MyStudent> myStudentList = new ArrayList<>();
        myStudentList.add(new MyStudent());
        myStudentList.add(new MyStudent("Harry", "Potter", 75.50));
        myStudentList.add(new MyStudent("Ronald", "Weasely", 86.00));
        myStudentList.add(new MyStudent("Hermione", "Granger", 91.70));
        myStudentList.add(new MyStudent("Parvati", "Patil", 93.75));

        String myName = myStudentList.get(0).getFirstName() +" " +myStudentList.get(0).getLastName();

        myHeader(3,2,myName,"Comparable");

        System.out.println(purple + "The Score Card:" + reset);
        for (MyStudent value : myStudentList) {
            System.out.println("\t" + value);
        }

        System.out.println(purple + "\nThe sorted list in terms of score in descending order...." + reset);

        MyStudent score = new MyStudent();
        Collections.sort(myStudentList);
        for (MyStudent value : myStudentList) {
            System.out.println("\t" + value);
        }

        System.out.println(purple + "\nThe sorted list in terms of first Names...." +reset);
        HelperClassCompareFirstNames fN = new HelperClassCompareFirstNames();
        Collections.sort(myStudentList, fN);
        for (MyStudent value : myStudentList) {
            System.out.println("\t" + value);
        }

        System.out.println(purple + "\nThe sorted list in terms of last Names...." + reset);
        HelperClassCompareLastNames lN = new HelperClassCompareLastNames();
        Collections.sort(myStudentList, lN);
        for (MyStudent value : myStudentList) {
            System.out.println("\t" + value);
        }

        myFooter(3,2);
    }



}
