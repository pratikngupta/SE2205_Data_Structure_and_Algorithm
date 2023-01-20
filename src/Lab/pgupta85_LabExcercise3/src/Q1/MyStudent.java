/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 18th October
 * Task: Work with DLL
 What will this code do?
    1) it contains method and field related to the Student class
    2) It will help to create a Student object
    3) It will help to get and set the name and id of the student
 *************************************************************************************************************************/

package Lab.pgupta85_LabExcercise3.src.Q1;

public class MyStudent {
    private final String firstName;
    private final double score;

    public MyStudent() {
        this.firstName = "Pratik";
        this.score = 100;
    }

    public MyStudent(String firstName, double score) {
        this.firstName = firstName;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", firstName, score);
    }

}
