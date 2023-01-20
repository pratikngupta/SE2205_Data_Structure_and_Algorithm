/***********************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Date: 10/20/2020
 * Student ID: 251211859
 * Task: Sort the names and grades of students in ascending order of grades and descending order of names
 * What does the code do:
 * 1 This StudentGrade class implements the Comparable interface
 *
 **********************************************************************************************************************/

package Assignment.pgupta85_Assignment2.src.Q2;

public class StudentGrade implements Comparable<StudentGrade> {

    //Declaring the variables
    private String firstName;
    private String lastName;
    private int grade;

    //Constructor
    //This constructor will initialize the variables
    public StudentGrade(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    //Getters and Setters for the variables
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //This method will return the string of the variables
    @Override
    public String toString() {
        //return in format of: "Pratik Gupta: 100"
        return String.format("%20s:\t %d", (firstName + " " + lastName), grade);
    }

    //This method will compare the grades of the students
    @Override
    public int compareTo(StudentGrade o) {
        if (this.grade > o.grade) {
            return 1;
        } else if (this.grade < o.grade) {
            return -1;
        } else {
            return 0;
        }
    }
}
