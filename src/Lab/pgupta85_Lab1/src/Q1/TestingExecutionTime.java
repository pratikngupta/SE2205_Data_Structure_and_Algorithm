/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 18th September
 * Task: Learn more about execution time of our code.
 What will this code do?
 -> It will ask user to enter number to calculate factorial for
 -> It will then calculate factorial using Iterative inside main, Iterative method and Using Recursive method
 -> It will also calculate the time taken using System.nanotime() by each of the method and display it to user.
 *************************************************************************************************************************/

package Lab.pgupta85_Lab1.src.Q1;

// Importing Ask class to get input from user, this class is in \src\Method\Ask.java
import Lab.pgupta85_Lab1.src.Method.Ask;

public class TestingExecutionTime {

    // Declaring ANSI_RESET so that we can reset the color
    // In next 4, we will be declaring color, so we can use it to print out some colorful output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPlE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";

    //Creating static methods call myHeader which will accept integers as formal parameter
    public static void myHeader(int qNumber) {
        //Using printf to print and format message, %d will help to print integers variable
        System.out.printf(ANSI_BLUE + """
                ===============================================================================
                Lab Exercise 1
                Question Number %d
                Prepared by: Pratik Narendra Gupta
                Student Number: 251211859
                Goal of this exercise: Working with loop and array
                ===============================================================================
                """ + ANSI_RESET, qNumber);
    }

    //Creating static methods call myFooter which will accept integers as formal parameter
    public static void myFooter(int qNumber) {
        //Using printf to print and format message, %d will help to print integers variable
        System.out.printf(ANSI_BLUE + """
                ===============================================================================
                Completion of lab exercise %d was successful
                Signing of Pratik
                ===============================================================================
                """ + ANSI_RESET, qNumber);
        System.exit(0);
    }

    // Creating factorialIterative method which accept integers as formal parameter and will return double type variable
    public static double factorialIterative (int number){

        //Declaring and initializing the variable required.
        double step = 1;
        double result = 1;

        while (step <= number){
            result = result * step;
            step ++;
        }

        return result;
    }

    // Creating factorialRecursive method which accept integers as formal parameter and will return double type variable
    public static double factorialRecursive(int number){

        //Using i and else statement
        if (number == 1 || number ==0 ){
            return 1;
        }
        else return number* factorialRecursive(number-1);
    }

    //This method will receive the time in nanosecond and will return the value in sec.
    public static double convertSecond (double endTime, double startTime) {
        return (endTime - startTime) /1000000000;
    }

    public static void main (String [] args){
        //Define and initiate variable required.
        int number = 0;
        double result = 1;
        double step = 1;
        double startTime;
        double endTime;
        myHeader(1);

        //Getting number from the user and validating using help of do/while loop.
        do {
            if (number < 0){
                System.out.println(ANSI_RED +"\nPlease enter Positive number or Zero" + ANSI_RESET);
            }
            number = Ask.getInt("Enter number you wish to calculate factorial for");
        }
        while (number < 0 );

        //Getting time from System.nanotime() and storing it to start time.
        startTime = System.nanoTime();

        //Calculating Factorial iteratively using help of While loop
        while (step <= number){
            result = result * step;
            step ++;
        }

        //Getting time from System.nanotime() and storing it to end time.
        endTime = System.nanoTime();

        //Using Iterative inside main, use %2.1e as formatter, 2 means number of sig fig to include and 1 mean number of sig fig after decimal.
        System.out.printf(ANSI_PURPlE + "\nUsing Iterative inside main\n"+ ANSI_RESET);
        System.out.printf("Factorial of number %d: %2.1e\n", number, result);
        System.out.printf("Total time taken: %3.2e second\n", convertSecond(endTime,startTime));

        //Using Iterative method
        System.out.printf(ANSI_PURPlE + "\nUsing Iterative method\n"+ ANSI_RESET);
        startTime = System.nanoTime();
        result = factorialIterative(number); //calling factorialIterative method
        endTime = System.nanoTime();
        System.out.printf("Factorial of number %d: %2.1e\n", number, result);
        System.out.printf("Total time taken: %3.2e second\n", convertSecond(endTime,startTime));

        //Using Recursive method
        System.out.printf(ANSI_PURPlE + "\nUsing Recursive method\n"+ ANSI_RESET);
        startTime = System.nanoTime();
        result = factorialRecursive(number); //Calling factorialRecursive Method.
        endTime = System.nanoTime();
        System.out.printf("Factorial of number %d: %2.1e\n", number, result);
        System.out.printf("Total time taken: %3.2e second\n\n", convertSecond(endTime,startTime));

        //Calling myFooter
        myFooter(1);
    }

}
