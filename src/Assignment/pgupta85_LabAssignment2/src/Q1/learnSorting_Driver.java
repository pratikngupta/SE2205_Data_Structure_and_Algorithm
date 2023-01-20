/***********************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Date: 10/20/2020
 * Student ID: 251211859
 * Task: learn more about execution time of different sorting algorithms
 * What will this code do?
 * 1) This code will sort the array using different sorting algorithms and will print the time taken by each algorithm to sort the array.
 * 2) It will also print the sorted array.
 * We will be working with collection. Sort, bubble sort, selection sort, insertion sort, merge sort, quick sort, bucket sort.
 **********************************************************************************************************************/

package Assignment.pgupta85_LabAssignment2.src.Q1;

import static  Assignment.pgupta85_LabAssignment2.src.Method.Intro.*;
import static Assignment.pgupta85_LabAssignment2.src.Q1.PratikTestingSortingMethods.*;
import java.util.*;

public class learnSorting_Driver {

    //Declaring and initializing various variables to be use in program.
    //This is global variable so that it can be used in all the methods.
    //Duration is used to store the time taken by each algorithm to sort the array.
    //size is used to store the size of the array.
    //Comments is boolean variable to check if the user wants to see the comments or not.
    //mainArray is used to store the array that is to be sorted.
    //dataBaseArray is used to store the sorted array.
    //backupArray is used to store the backup of the mainArray. which will be copied to main array before each sorting algorithm.

    public static double duration;
    public static boolean comment = true;
    public static int size = 5;
    public static int count = 0;
    public static Integer[] mainArray = new Integer[size];
    public static Integer[] backupArray = new Integer[size];
    public static int[][] dataBaseArray = new int[7][size];


    //Method to convert nanosecond to millisecond
    //It will also copy sorted array to dataBaseArray; and backupArray to mainArray to be used in next sorting algorithm.
    //it will return the time taken by the algorithm to sort the array in millisecond.
    public static double convertAndReset(long time) {
        //copy value from main array to dataBaseArray
        for (int i = 0; i < size; i++) {
            dataBaseArray[count][i] = mainArray[i];
        }
        //copy value from backup array to main array
        System.arraycopy(backupArray, 0, mainArray, 0, size);
        //convert nano seconds to milliseconds
        duration = time / 1000000.0;
        count++;
        return duration;
    }

    //Driver Method
    public static void main(String[] args) {
        //Calling method from Intro class to print the header
        myHeader(2, 1, "Pratik Narendra Gupta", "Understanding Sorting Methods");

        //create a hash map to store the duration of each sorting method
        LinkedHashMap<String, Double> durationMap = new LinkedHashMap<>();

        //Declaring variables
        long startTime;
        long endTime;

        //populate mainArray array with random values from 13 to 93 inclusive
        for (int i = 0; i < size; i++) {
            //range: 13 to 93 inclusive = 93-13+1 = 81
            //min = 13
            mainArray[i] = (int) (Math.random() * 81 + 13);
        }

        //copy value from main array to back up array
        System.arraycopy(mainArray, 0, backupArray, 0, size);

        //convert mainArray to list
        List<Integer> list = Arrays.asList(mainArray);

        System.out.println( cyan +"Testing execution time of different sorting methods on an array of size " + size + " with random values from 13 to 93 inclusive." + reset);

        //Using collection to sort the array
        startTime = System.nanoTime();
        Collections.sort(list);
        endTime = System.nanoTime();

        //calling method to convert nanoseconds to milliseconds and to copy the sorted array to dataBaseArray
        //Using the durationMap to store the time taken by the algorithm to sort the array
        //Respected algorithm name is used as key and time taken by the algorithm to sort the array is used as value
        durationMap.put("Collections Sort", convertAndReset(endTime - startTime));
        durationMap.put("Selection Sort", convertAndReset(selectionSort(mainArray)));
        durationMap.put("Bubble Sort", convertAndReset(bubbleSort(mainArray)));
        durationMap.put("Insertion Sort", convertAndReset(insertionSort(mainArray)));
        durationMap.put("Merge Sort", convertAndReset(mergeSort(mainArray)));
        durationMap.put("Quick Sort", convertAndReset(quickSort(mainArray, 0, size - 1)));
        durationMap.put("Bucket Sort" , convertAndReset(bucketSort(mainArray,0,size-1,2)));

        //resetting the count to 0;
        count = 0;

        System.out.println();

        //if comment is false then it will not print out array;
       if (!comment) {
           //Using method from LinkedhashMap class to print the time taken by each algorithm to sort the array
           //It will print them out in the order they are stored in the LinkedHashMap
            for (Map.Entry<String, Double> entry : durationMap.entrySet()) {
                System.out.printf(green + "%20s:" + reset + "\t" + "%f" + reset + " milliseconds %n", entry.getKey(), entry.getValue());
            }
        }

       //If comment is true then it will print detail feedback
        else {
            for (Map.Entry<String, Double> entry : durationMap.entrySet()) {
                System.out.println(green + entry.getKey() + reset);
                System.out.println("Before Sorting: " + Arrays.toString(mainArray));
                System.out.println("After Sorting: " + Arrays.toString(dataBaseArray[count]));
                //print out line from dataBaseArray
                System.out.printf("Time Taken: %.2f milliseconds %n", entry.getValue());
                System.out.println();
                count++;
            }
        }

        //Calling method from Intro class to print the footer
        myFooter(2, 1);
    }
}
