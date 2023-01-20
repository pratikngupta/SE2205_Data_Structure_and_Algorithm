/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 18th September
 * Task: Working with arrays and numbers
 What will this code do?
 -> It will ask user for size of array
 -> It will ask user to populate array
 -> Then it will figure out maximum, minimum and average of number divisible by 5 and display it to user
 *************************************************************************************************************************/

package Lab.pgupta85_Lab1.src.Q2;

// Importing Ask class to get input from user, this class is in \src\Method\Ask.java

import Lab.pgupta85_Lab1.src.Method.Ask;

public class WorkingWithArrays {

    // Declaring ANSI_RESET so that we can reset the color
    // In next 3, we will be declaring color, so we can use it to print out some colorful output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
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

    //Create a static method which will return double type array and will accept integers array as formal parameter.
    public static double[] mma5MethodPratik(int[] array) {

        //Declaring and initializing various variable
        double[] result = {0, 0, 0, 251211859.0};

/*      result array is arrange in following format
        result [0] hold the largest number divisible by 5
        result [1] hold the lowest number divisible by 5
        result [2] hold the average value of number divisible by 5
        result [3] hold Student ID*/

        int n = 0; //Will help to cycle through all number in array
        int x = 0; //will store how many number are divisible by 5 in order to calculate average later on

        //Starting main loop to loop through all number in array, This loop will continue until all number in the array have been checked!
        while (n < array.length) {

            //Using if loop to verify that we have non-zero number, and it is divisible by 5
            if (array[n] != 0 && array[n] % 5 == 0) {

                //Assigning first number to min value for comparing later
                if (x == 0) {
                    result[1] = array[n];
                }

                //Checking if current number is highest
                if (array[n] > result[0]) {
                    result[0] = array[n];
                }

                //Checking if current number is lowest
                else if (array[n] < result[1]) {
                    result[1] = array[n];
                }

                //Adding number for average later on
                result[2] = result[2] + array[n];

                //Keeping count of how many number are divisible by 5
                x++;
            }
            //increasing the value of n to go through next number.
            n++;
        }

        //According to way logic is set, First it will check the value in result [2], if the value is greater than zero then it will print how many number were divisible by 5
        //If result [2] turn out to be zero, then it will check value of variable x. If x != o, then we have a case that average of number divisible by 5 turns out to be zero.
        //For example if user enter [1,2,3,5,-5], here we have 2 number divisible by 5 but their average is 0.
        //This if statement will check and print out the message according to scenario.
        if (result[2] != 0) {
            System.out.printf("There is %d number divisible by 5\n", x);
            result[2] = result[2] / x;
        }
        else if (x != 0){
            System.out.printf("There is %d number divisible by 5\n", x);
        }
        else {
            System.out.println("there is no number divisible by 5");
        }

        //This will return final result of this method in form of array.
        return result;
    }

    public static void main(String[] args) {

        //Declaring and initializing the variable for future use.
        int arraySize = 1;
        int n = 0; //Will help to cycle through all number in array
        int x = 1;

        //Create an array to store result get and store from mma5MethodPratik.
        double[] result = new double[4];

        //Calling myHeader
        myHeader(2);

        System.out.println( ANSI_RED + "\n*** The way code is set up, it will consider zero to be non divisible by 5 *** " + ANSI_RESET);
        System.out.println();

        //Starting do while loop, This loop will ignore the condition when running for first time.
        //If the user has not enter accepted value then it will ask user to enter the value again.
        do {
            if (arraySize <= 0) {
                //This will print message in red color so user can understand why code is not working.
                System.out.println(ANSI_BLUE +"\nPlease enter Positive number"+ANSI_RESET);
            }
            arraySize = Ask.getInt("Enter Size of Array");
        }
        while (arraySize <= 0);

        //Once we get array size from user we are creating new int type array.
        int[] array = new int[arraySize];

        //populate array with input from user
        while (n < array.length) {
            array[n] = Ask.getInt("Enter " + x + " Number");
            x++;
            n++;
        }

        System.out.println("\nHere is result...\n");

        //Calling mma5MethodPratik to find out average, max, min value.
        //Using system copy to copy the return array to result array.
        System.arraycopy(mma5MethodPratik(array), 0, result, 0, result.length);

        //According to way logic is set, if there are no number divisible by 5 then sum for average value in result [2] will be zero.
        //If the value is zero then it will not display max, min and avg value.
        if (result[2] != 0 || result [0] != 0 || result [1] != 0) {
            System.out.printf("""
                    The max number is: %.2f
                    The min number is: %.2f
                    The average of number divisible by 5 is: %.2f
                    My student number is: %d
                    """, result[0], result[1], result[2], (int) result[3]);
        }

        System.out.println("\n\n");
        //Calling footer
        myFooter(2);
    }
}
