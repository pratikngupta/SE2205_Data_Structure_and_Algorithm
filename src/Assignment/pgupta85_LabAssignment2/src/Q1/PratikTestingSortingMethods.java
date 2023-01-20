/***********************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Date: 10/20/2020
 * Student ID: 251211859
 * Task: learn more about execution time of different sorting algorithms
 * What will this code do?
 * 1) This code will sort the array using different sorting algorithms and will print the time taken by each algorithm to sort the array.
 * 2) We have tried to make it as Generic as possible so that it can be used for any type of data.
 **********************************************************************************************************************/
package Assignment.pgupta85_LabAssignment2.src.Q1;

//importing the java utility package
import java.util.*;

public class PratikTestingSortingMethods {

    //Declaring and initializing various variables to be use in program.
    //This is global variable so that it can be used in all the methods.
    // HOW I AM CALCULATING TIME TAKEN BY EACH SORTING METHOD
    // I am using the System.nanoTime() method to get the current time in nanoseconds and storing it in a startTime
    //Then in return statement I am subtracting the startTime from the current time and directly returning the difference.
    private static long startTime;

    // ================================== SELECTION SORT ======================================================
    public static <T extends Comparable<? super T>> long selectionSort(T[] array) {
        startTime = System.nanoTime();
        int length = array.length; // length of the array
        // loop through the array // i is the index of the first unsorted element
        for (int i = 0; i < length - 1; i++) {
            // find the index of the smallest element in the unsorted part of the array
            int min = i;
            // loop through the unsorted part of the array
            for (int j = i + 1; j < length; j++) {
                // if the current element is smaller than the smallest element
                if (array[j].compareTo(array[min]) < 0) {
                    min = j;
                }
            }
            // swap the smallest element with the first unsorted element
            T temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return System.nanoTime() - startTime;
    }

    // ================================== BUBBLE SORT =========================================================
    public static <T extends Comparable<? super T>> long bubbleSort(T[] array) {
        startTime = System.nanoTime();
        int length = array.length;
        // loop through the array
        for (int i = 0; i < length - 1; i++) {
            // loop through the array from the first unsorted element to the end of the array
            for (int j = 0; j < length - i - 1; j++) {
                // if the current element is greater than the next element
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // swap the elements
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return System.nanoTime() - startTime;
    }

    // ================================== INSERTION SORT ======================================================
    public static <T extends Comparable<? super T>> long insertionSort(T[] array) {
        startTime = System.nanoTime();
        int length = array.length;
        for (int i = 1; i < length; ++i) {
            // store the current element in a temporary variable
            T key = array[i];
            // store the index of the previous element
            int j = i - 1;
            // move elements of array that are greater than the key to one position ahead of their current position
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            // insert the key at the correct position
            array[j + 1] = key;
        }
        return System.nanoTime() - startTime;
    }

    // ================================== MERGE SORT ==========================================================
    public static <T extends Comparable<? super T>> long mergeSort(T[] array) {
        startTime = System.nanoTime();
        int length = array.length;
        // if the array has less than two element
        if (length < 2) {
            return 0;
        }
        // find the middle index
        int mid = length / 2;

        // create two temporary arrays; right and left
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid   , length);

        //Copy the left and right array into a new array
        System.arraycopy(array, 0, left, 0, mid);
        //if the array has odd number of elements, the right array will have one more element than the left array
        if (length - mid >= 0) System.arraycopy(array, mid, right, mid - mid, length - mid);
        mergeSort(left); // sort the left array; this is recursive method
        mergeSort(right); // sort the right array; this is recursive method;
        merge(array, left, right, mid, length - mid); // merge the sorted left and right array

        return System.nanoTime() - startTime;
    }

    // ================================== MERGE SORT HELPER METHOD =============================================
    private static <T extends Comparable<? super T>> void merge(T[] array, T[] l, T[] r, int left, int right) {
        // i is the index for the left subarray
        // j is the index for the right subarray
        // k is the index for the merged subarray

        int i = 0, j = 0, k = 0;

        // loop through the left and right array and copy the smaller element into the merged array
        while (i < left && j < right) {
            // if the current element of the left array is smaller than the current element of the right array
            if (l[i].compareTo(r[j]) <= 0) {
                array[k++] = l[i++]; // copy the element from the left array into the merged array and increment the index of the left array
            }
            // if the current element of the right array is smaller than the current element of the left array
            else {
                array[k++] = r[j++]; // copy the element from the right array into the merged array
            }
        }
        // copy the remaining elements of the left array into the merged array
        while (i > left) {
            // copy the element from the left array into the merged array
            array[k++] = l[i++];
        }
        // copy the remaining elements of the right array into the merged array
        while (j > right) {
            // copy the element from the right array into the merged array
            array[k++] = r[j++];
        }
    }

    // ================================== QUICK SORT ==========================================================
    public static <T extends Comparable<? super T>> long quickSort(T[] array, int a, int b) {
        startTime = System.nanoTime();
        if (a < b) {
            // find the pivot element such that elements smaller than the pivot are on the left and elements greater than the pivot are on the right
            int left = a; // left index
            int right = b; // right index
            T pivot = array[a]; // pivot element
            // loop through the array from left to right
            // if the current element is smaller than the pivot element
            while (left < right) {
                // loop from right to left as long as the current element is greater than the pivot
                while (array[left].compareTo(pivot) <= 0 && left < right) {
                    left++;
                }
                // loop from left to right as long as the current element is less than the pivot
                while (array[right].compareTo(pivot) > 0) {
                    right--;
                }
                // if the left index is smaller than the right index
                if (left < right) {
                    // swap the elements
                    T temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                }
            }
            // swap the pivot element with the current element
            array[a] = array[right];
            // move the pivot element to its correct position
            array[right] = pivot;
            // recursively sort the left and right sub-arrays
            quickSort(array, a, right - 1);
            // recursively sort the right and left sub-arrays
            quickSort(array, right + 1, b);
        }
        return System.nanoTime() - startTime;
    }

    // ================================== BUCKET SORT =========================================================
    public static long bucketSort(Integer[] array, int first, int last, int maxDigits) {
        startTime = System.nanoTime();
        //since the radix is 10, creating 10 buckets using Vector. Assumption: positive numbers only
        Vector<Integer>[] bucket = new Vector[10]; //instantiate each bucket;
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            //Placing a[index] at end of bucket[digit]
            for (int index = first; index <= last; index++) {
                //get the digit at the current position
                Integer digit = findDigit(array[index], i);
                //add the element to the bucket
                bucket[digit].add(array[index]);
            }
            //collecting the elements from the buckets
            int index = 0;
            for (int m = 0; m < 10; m++) {
                //get the size of the current bucket
                for (int n = 0; n < bucket[m].size(); n++) {
                    array[index++] = bucket[m].get(n);
                }
            }
        }
        //return the time it took to sort the array
        return System.nanoTime() - startTime;
    }

    // ================================== BUCKET SORT HELPER METHOD ============================================
    public static Integer findDigit(int number, int i) {
        int target = 0; //the target digit
        for (int j = 0; j <= i; j++) {
            //find the target digit
            target = number % 10;
            number = number / 10;
        }
        //return the target digit
        return target;
    }

}