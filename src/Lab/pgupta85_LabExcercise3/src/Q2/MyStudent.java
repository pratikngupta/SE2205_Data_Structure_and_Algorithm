/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 18th October
 * Task: Work with interfaces and Collections
 What will this code do?
 1) it contains method and field related to the Student class
 2) It will help to create a Student object
 3) It will help to get and set the name and id of the student
 4) It will implement Comparable interface to compare the student object
 *************************************************************************************************************************/

package Lab.pgupta85_LabExcercise3.src.Q2;

public class MyStudent implements Comparable<MyStudent> {
    private String firstName;

    private String lastName;
    private double score;

    public MyStudent() {
        this.firstName = "Pratik";
        this.lastName = "Gupta";
        this.score = 100;
    }

    public MyStudent(String firstName, String LastName, double score) {
        this.firstName = firstName;
        this.lastName = LastName;
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", firstName, lastName, score);
    }

    @Override
    public int compareTo(MyStudent student) {
        if (this.score > student.score) {
            return -1;
        } else if (this.score < student.score) {
            return 1;
        } else {
            return 0;
        }
    }
}
