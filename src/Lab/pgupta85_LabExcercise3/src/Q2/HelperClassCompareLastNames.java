/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 18th October
 * Task: Work with interfaces and Collections
 What will this code do?
 1) helperclass to compare the last name of the student
 2) It will help to compare the last name of the student
 3) It will implement Comparator interface to compare the student object
 *************************************************************************************************************************/



package Lab.pgupta85_LabExcercise3.src.Q2;

import java.util.Comparator;

public class HelperClassCompareLastNames implements Comparator <MyStudent> {

    public int compare(MyStudent s1, MyStudent s2){
        return s1.getLastName().compareTo(s2.getLastName());
    }

}
