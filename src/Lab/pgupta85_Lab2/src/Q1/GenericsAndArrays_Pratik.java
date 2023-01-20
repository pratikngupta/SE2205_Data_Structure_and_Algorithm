/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 1st October
 * Task: Work with ArrayList and Generics
 What will this code do?
 1) This code will create an ArrayList of type Integer and Number
 2) Then it will create array of Pair type reference variables
 3) Using constructor of Pair class, it will create objects of Pair class and assign it to array of Pair type reference variables
 4) Then it will ask user to enter year
 5) Using for loop, it will check if year entered by user is equal to year in Pair object
 6) If year is equal, it will print out the value of Pair object
 *************************************************************************************************************************/

package Lab.pgupta85_Lab2.src.Q1;

import Lab.pgupta85_Lab2.src.Method.*;  //Import Ask class from Method package
import java.util.*; //Importing package for ArrayList and Arrays

public class GenericsAndArrays_Pratik {

    // Declaring ANSI_RESET so that we can reset the color
    // In next 4, we will be declaring color, so we can use it to print out some colorful output
    public static final String ANSI_RESET  = "\u001B[0m";
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED    = "\u001B[31m";

    //Creating static methods call myHeader which will accept integers and string as formal parameters
    public static void myHeader(int labNumber,int qNumber, String message){
        //Using printf to print and format message, %d will help to print integers variable
        System.out.printf(ANSI_BLUE + """
                ===============================================================================
                Lab Exercise %d
                Question Number %d
                Prepared by: Pratik Narendra Gupta
                Student Number: 251211859
                Goal of this exercise: %s
                ===============================================================================
                """ + ANSI_RESET, labNumber, qNumber, message);
    }

    //Creating static methods call myFooter which will accept integers as formal parameters
    public static void myFooter(int labNumber,int qNumber) {
        //Using printf to print and format message, %d will help to print integers variable
        System.out.printf(ANSI_BLUE + """
                ===============================================================================
                Completion of lab %d, Question %d was successful
                Signing off Pratik
                ===============================================================================
                """ + ANSI_RESET, labNumber, qNumber);
        System.exit(0);
    }

    //driver method
    public static void main(String[] args) {

        //creating ArrayList of type Integer to store year va
        ArrayList<Integer> year = new ArrayList<>(Arrays.asList(2,3,4,3,2,2));

        //creating ArrayList of type String to store name of person.
        ArrayList<String> name = new ArrayList<>(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent"));

        //Creating Arraylist of type String to store the name of the person as result
        ArrayList<String> result = new ArrayList<>();

        int yearEntered; //Creating yearEntered variable to store year entered by user
        char ask = 0; //Declaring ask variable to ask if user want to continue

        //Creating array of Pair type reference variables
        //Using for loop to create objects of Pair class and assign it to array of Pair type reference variables
        Pair<Integer, String>[] profile = new Pair[name.size()];
        for (int i = 0; i < name.size(); i++) {
            profile[i] = new Pair<>(year.get(i), name.get(i));
        }

        //Calling myHeader method to print out header
        myHeader(2,1,"Working with ArrayList and Generics");

        System.out.println("""
                This program prints the names of the student leaders from year 2, 3 and 4.
                To see the list of the students from a specific year enter an integer between 2 and 4 when prompted.
                """);

        //Using do while loop to ask user if he/she want to continue, this will not check value when running o first time
        do {

            //Using Ask.getInt to ask user to enter year. passing message and int 1 as formal parameters. 1 will ensure that user will enter integer.
            yearEntered = Ask.getInt("Enter Academic Year (2, 3 or 4)", 1);
            if (yearEntered >= 2 && yearEntered <= 4) { //Checking if year entered by user is between 2 and 4

                //Using for loop to check if year entered by user is equal to year in Pair object, if yes then it will add name of person to result arraylist.
                for (Pair<Integer,String> check : profile) {
                    if (check.getKey() == yearEntered) {
                        result.add(check.getValue());
                    }
                }

                //Showing result to user
                System.out.println("\nFound " + result.size() + " student leader(s) in year " + yearEntered);
                System.out.println("They are: " + result + "\n");
                result.clear(); //clearing result arraylist so that it can be used again

                //Asking user if he/she want to continue, Using Ask.getChar to ask user to enter year. passing message and int 1 as formal parameters.
                // 1 will ensure that character is always converted to uppercase.
                ask = Ask.getChar( ANSI_PURPLE + "Do you want to continue (Y/N)" + ANSI_RESET, 1);
                System.out.println();
            }

            else { //If year entered by user is not between 2 and 4, it will print out message to ask user to enter year between 2 and 4
                System.out.println(ANSI_RED + "Please enter valid year" + ANSI_RESET);
                ask = 'Y' ; //changing ask to Y so that it will ask user to enter year again.
            }

        }
        while (ask == 'Y'); //Checking if user want to continue

        //Calling myFooter method to print out footer
        myFooter(2,1);
    }

}
