/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 6 Nov
 * Task: Work on File, Map and Set
 What will this code do?
1) This code will read the file and store the data in a map.
2) It will then print the map according to first and last name.
 *************************************************************************************************************************/

package Lab.pgupta85_LabExcercise4.src.Q1;

import java.io.*; // for file handling and exceptions
import java.util.*; // for Map, HashMap, Set, TreeSet
import static   Lab.pgupta85_LabExcercise4.src.Method.Intro.*; //importing the Intro class from the Method package

public class PratikExerciseOnFileMapSet {

    public static void main(String[] args) {
        myHeader(4,1,"Pratik Gupta","Exercise on File, Map and Set");

        //Setting up the file with try catch block to handle the exception
        Scanner input = null;
        try {
            File nameList = new File("src/Lab/pgupta85_LabExcercise4/src/Q1/SE2205Students.txt");
            input = new Scanner(nameList);
        } catch (FileNotFoundException e) {
            System.out.println(red + "File not found!");
            System.out.println("Please check the file path and try again." + reset);
            System.exit(0);
        }

        //Declaring and initializing map
        TreeMap<String, Integer> firstName = new TreeMap<>();
        TreeMap<String, Integer> lastName = new TreeMap<>();

        //Reading file and storing data in map
        while (input.hasNextLine()) {
            //Reading next line
            String line = input.nextLine();
            //Splitting line into array
            String[] name = line.split(" ");
            //variable to store first name and last name
            String first = name[name.length - 1];
            String last = name[0];

            //calling method to store data in map and to check if it is already present
            populateTreeMap(lastName, last);
            populateTreeMap(firstName, first);
        }
        //closing the file
        input.close();

        //Printing the map
        System.out.println(purple + "\nNumber of students with same last name: ");
        System.out.println(green + """
                +-----------------+----------------+
                |    Last Name    |    Number      |
                +-----------------+----------------+""" + reset);
        printMap(lastName); //calling method to print the map

        System.out.println(purple+"\nNumber of students with same first name: ");
        System.out.println(green +"""
                +-----------------+----------------+
                |    Last Name    |    Number      |
                +-----------------+----------------+""" + reset);
        printMap(firstName);

        System.out.println();
        myFooter(4,1);
    }

    //creating a method to populate the tree map, it will receive the tree map and the name
    public static void populateTreeMap(TreeMap<String, Integer> name, String nameToCount) {
        if (name.containsKey(nameToCount)) {
            name.put(nameToCount, name.get(nameToCount) + 1);
        } else {
            name.put(nameToCount, 1);
        }
    }

    public static void printMap(TreeMap<String, Integer> map) {
        int count = 0;
        for (String key : map.keySet()) {
            if (map.get(key) >= 2) {
                //change the color for alternate lines
                if (count % 2 == 0) {
                    System.out.printf(yellow + "%14s %8d %n" + reset, key, map.get(key));
                }
                else {
                    System.out.printf( "%14s %8d %n" , key, map.get(key));
                }
                count++;
            }
        }
    }

}
