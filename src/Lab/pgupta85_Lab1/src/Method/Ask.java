/******************************************************
 Name: Pratik Narendra Gupta
 Student ID: 251211859
 Date: 18th September
 Task: Create a class which can be imported and make writing code easy.
        What will this class do?
        1) This is an advance Scanner with few additional feature
        2) This will help in getting input from user and assign it to variable
        3) this will avoid declaring, import Scanner class in every java file.
        4) Coder will be able to pass message and request the type of input he/she is hoping to get.
        5 Depending on type of request, this will print out message, get input from user and return that input.
 *********************************************************/

package Lab.pgupta85_Lab1.src.Method;

//Import Scanner Class
import java.util.Scanner;

public class Ask {

    //Declaring Scanner type reference variable
    public static Scanner input = new Scanner(System.in);

    //This will accept string message and will print it on screen
    public static void printMessage(String message){
        if (message.length()>0){
            System.out.print(message);
        }
        System.out.print(": ");
    }

    //This will accept string message and will return integer value it got from user.
    //Only flaw is that this will assume that user has entered integers value.
    //Will fixed this flaw later on.
    public static int getInt (String message){
        printMessage(message);
        return input.nextInt();
    }

    //This will accept string message and will return double value it got from user.
    public static double getDouble (String message){
        printMessage(message);
        return input.nextDouble();
    }

    //This will accept string message and int value and will return char value it got from user.
    //Once advantage is that coder can request to return char in lowercase or uppercase.
    //For example if I set option to 0, then char will be converted to lowercase before returning value.
    //For example if I set option to 1, then char will be converted to uppercase before returning value.
    public static char getChar (String message, int options){
        char getChar;
        printMessage(message);
        getChar = input.next().charAt(0);
        if (options == 0){
            return Character.toLowerCase(getChar);
        }
        else if (options == 1){
            return Character.toUpperCase(getChar);
        }
        return input.next().charAt(0);
    }

    //This will accept string message and int value and will return string value it got from user.
    public static String getString (String message){
        printMessage(message);
        if (input.hasNextLine()){
            input.nextLine();
        }
        return input.nextLine();
    }
}

