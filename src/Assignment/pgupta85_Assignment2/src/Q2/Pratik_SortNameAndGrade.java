/***********************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Date: 10/20/2020
 * Student ID: 251211859
 * Task: Sort the names and grades of students in ascending order of grades and descending order of names
 * What does the code do:
 * 1. It will create an array of student first name and last name
 * 2. it will create an array of grades
 * 3. Using math.random it will generate random grades for each student
 * 4. It will sort the grades in ascending order
 * 5. It will sort the names in descending order
 * 6. It will print the sorted names and grades
 **********************************************************************************************************************/

package Assignment.pgupta85_Assignment2.src.Q2;

import java.util.*;
import static  Assignment.pgupta85_Assignment2.src.Method.Intro.*;

public class Pratik_SortNameAndGrade {
    public static void main(String[] args) {
        //Calling myHeader
        myHeader(2,2,"Pratik Gupta","Comparable");

        //Creating an array of student first name and last name
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny","Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley","Malfoy", "Thomas", "Weasley"};

        //Creating an array of grades
        Integer[] grd = {(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),
                (int)(60 + Math.random()*26),(int) (60 + Math.random()*26),
                (int)(60 + Math.random()*26),(int)(60 + Math.random()*26),
                (int)(60 + Math.random()*26),(int)(60 + Math.random()*26)};


        ////create a Vector<> class instance ‘sg’ with StudentGrade tag.
        Vector<StudentGrade> sg = new Vector<>();

        //Add each StudentGrade object to the Vector class with its add method
        for (int i = 0; i < fnArray.length; i++) {
            sg.add(new StudentGrade(fnArray[i],lnArray[i],grd[i]));
        }

        //Print the Vector class instance ‘sg’ with its toString method
        System.out.println(green+"\n" +"The Unsorted Array ................"+reset);
        sg.forEach(System.out::println);
        System.out.println();

        ////Create an array of StudentGrade type with the length of the fnArray that has been created above.
        StudentGrade[] sgArray = new StudentGrade[fnArray.length];

        //with the help of Vector’s copyInto() method, copy ‘sg’ to StudentGrade array you just created above
        sg.copyInto(sgArray);

        //=====================================SORT BY GRADE====================================================
        ////sort ‘sg’ using Collections’ sort method, which will sort the list based on the grade
        Collections.sort(sg);
        //print the sorted list
        System.out.println(green +"Sorted by Grades..................." + reset);
        sg.forEach(System.out::println); //print the sorted list

        //=====================================SORT BY FIRST NAME==============================================
        sort(sgArray,1); //sort the array based on the first name
        //print the sorted array (see the sample output) with the aid of your printArray() method
        System.out.println();
        System.out.println(green + "\n" +"Sorted by First Names ............." + reset);
        printArray(sgArray);
        System.out.println();

        //=====================================SORT BY LAST NAME===============================================
        sort(sgArray,2); //sort the array based on the last name
        System.out.println(green + "Sorted by Last Names..............." + reset);
        printArray(sgArray);
        System.out.println();
        myFooter(2,2);
    }

    //printArray method
    //This method will print the array
    public static void printArray(StudentGrade[] sgArray){
        for (StudentGrade studentGrade : sgArray) {
            System.out.println(studentGrade);
        }
    }

//create a stable insertion sort method to sort the array based on the first name or last name
public static void sort(StudentGrade[] sgArray, int key) {
    //if key is 1 then sort the array according to first name
    if (key == 1) {
        //sort the array according to first name
        for (int i = 1; i < sgArray.length; i++) {
            //create a temp variable to store the value of sgArray[i]
            StudentGrade temp = sgArray[i];
            int j = i - 1; //create a variable j to store the value of i-1
            //if the value of j is greater than 0 and the value of temp is less than the value of sgArray[j]
            while (j >= 0 && sgArray[j].getFirstName().compareTo(temp.getFirstName()) > 0) {
                //swap the values
                sgArray[j + 1] = sgArray[j];
                j--;
            }
            //assign the value of temp to sgArray[j+1]
            sgArray[j + 1] = temp;
        }
    }
    // Is key is 2; it will sort according to last name
    else if (key == 2) {
        //sort the array according to last name
        for (int i = 1; i < sgArray.length; i++) {
            //create a temp variable to store the value of sgArray[i]
            StudentGrade temp = sgArray[i];
            int j = i - 1; //create a variable j to store the value of i-1
            while (j >= 0 && sgArray[j].getLastName().compareTo(temp.getLastName()) > 0) {
                //swap the values
                sgArray[j + 1] = sgArray[j];
                j--;
            }
            //assign the value of temp to sgArray[j+1]
            sgArray[j + 1] = temp;
        }
    }
}
}
