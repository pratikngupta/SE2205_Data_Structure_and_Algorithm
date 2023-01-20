/***********************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Date: 27 Nov 2022
 * Student ID: 251211859
 * Task: Main class for the hash table
 * What will this code do?
 * it will ask user to decide which class demo he wants to see
 * it will call the class demo
 **********************************************************************************************************************/

package Assignment.pgupta85_LabAssignment3.src.Q2;

import Assignment.pgupta85_LabAssignment3.src.Q1.PratikValueEntry;

import static Assignment.pgupta85_LabAssignment3.src.Method.Intro.*; //importing the Intro class from Method package
import static Assignment.pgupta85_LabAssignment3.src.Q1.PratikDemoHashingWithLinearProbing.*; //importing the methods from PratikDemoHashingWithLinearProbing.java

public class PratikDemoHashingWithAllOpenAddressingTechniques {

    // Define a public static void method addValueQuadraticProbe (Integer), which will accept an integer key and add this to the hash table based on quadratic probing technique. tableCapacity stores the size of table
    public static void addValueQuadraticProbe (int key) throws Exception{
        //find the hash value
        int hashKey = key % tableCapacity;
        //if index is negative, make it positive
        if (hashKey< 0){
            hashKey = hashKey + tableCapacity;
        }

        //counter to count
        int counter = 0;

        //probing
        int probe = hashKey % tableCapacity;

        //if the index is not empty, then probe
        while (hashTable [probe].getKey() != -1 && hashTable[probe].getKey() != -111) {
            if (counter == tableCapacity * 2)
                throw new Exception("Probing failed! Use a load factor of 0.5 or less. Goodbye!");
            counter++;
            probe = (hashKey + (counter * counter)) % tableCapacity;
        }

        //if the index is empty, then add the value
        hashTable[probe].setKey (key) ;
    }

    // Define a public static void method addValueDoubleHash (Integer), which will accept an integer key and add this to the hash table based on double hashing technique. tableCapacity stores the size of table
    public static void addValueDoubleHashing(int key) {
        //find the hash value
        int prime = thePrimeNumberForSecondHashing(); //find the prime number for second hashing
        int firstHash = key % tableCapacity; //first hash
        int secondHash = prime - (key % prime); //second hash

        //if index is negative, make it positive
        if (firstHash < 0){
            firstHash += tableCapacity;
        }

        int j = 0;
        int probe = (firstHash + (j * secondHash) )% tableCapacity;

        //Check if the index is empty, if not, then probe
        while (hashTable[probe].getKey() != -1 && hashTable[probe].getKey() != -111 ){
            j++;
            probe = (firstHash + (j * secondHash)) % tableCapacity;
        }

        hashTable[probe].setKey(key);
    }

    //will return the prime number q for the second hash function.
    //(c) Define a public static method called thePrimeNumberForSecondHashFunction(int) method that will return the prime number q for the second hash function by accepting the current table capacity. The goal here is to get a second prime number which is immediately smaller that the table capacity (if the table capacity is 23, the second prime number should be 19). To define this one, you can modify the code provided to you for checkPrime(int) method in question 1.
    public static int thePrimeNumberForSecondHashing() {
        //find the prime number for second hashing
        int prime = tableCapacity - 1;
        //check if the prime number is prime
        while (!isPrime(prime)) {
            prime--;
        }
        //return the prime number
        return prime;
    }
    public static boolean isPrime (int n) {
        //check if the number is prime
        if (n <= 1)
            //if the number is less than or equal to 1, then it is not prime
            return false;
        //check if the number is prime
        for (int i = 2; i < n; i++)
            //if the number is divisible by any number, then it is not prime
            if (n % i == 0)
                return false;
        //if the number is not divisible by any number, then it is prime
        return true;
    }


    public static void performOperation(int[] dataSet) {

        //method to perform the operation

        tableCapacity = checkPrime((int) (items / loadFactor)); //get the table capacity

        System.out.println("The minimum required table capacity would be: " + tableCapacity + "\n");

        //Create a QuaziValueEntry type array of size of the table-capacity (from iv) and assign that
        //to hashTable field.
        hashTable = new PratikValueEntry[tableCapacity]; //create the hash table

        //initialize the hashTable array with -1
        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i] = new PratikValueEntry();
        }

        //Create the working hash table
        workingHashTable = new PratikValueEntry[tableCapacity];
        //Initialize the working hash table
        for (int i = 0; i < tableCapacity; i++) {
            workingHashTable[i] = new PratikValueEntry();
        }

        printArray(dataSet);
        System.out.println("Let's enter each data item from the above to the hash table");

        //Add the data items to the hash table using linear probing technique
        System.out.println(cyan + "\nUsing Linear Probing" + reset);
        for (int number : dataSet) {
            addValueLinearProbe(number);
        }
        System.out.print("The hash table is: ");
        printHashTable();
        emptyHashTable();

        //Add the data items to the hash table using quadratic probing technique
        System.out.println(cyan + "\nUsing Quadratic Probing" + reset);
        try {
            for (int number : dataSet) {
                addValueQuadraticProbe(number);
            }
        }
        catch (Exception addValueQuadraticProbe){
            System.out.println(red +"Quadratic prob failed as " + "load factor is greater than 0.5" + reset);
        }
        System.out.print("The hash table is: ");
        printHashTable();
        emptyHashTable();

        //Add the data items to the hash table using double hashing technique

        System.out.println(cyan + "\nUsing Double Hashing" + reset);
        System.out.println("The q value is: " + thePrimeNumberForSecondHashing());

        for (int number : dataSet) {
            addValueDoubleHashing(number);
        }
        System.out.print("The hash table is: ");
        printHashTable();
        emptyHashTable();
    }

    public static void printArray(int[] array) {
        System.out.printf(purple);
        System.out.print("The given dataset is: [");

        //This will print the content of the hash table.
        for (int number : array) {
            System.out.print(number + ", ");
        }
        //This will print the content of the hash table.
        System.out.println("\b\b]");
        System.out.printf(reset);
    }

    //empty the hash table
    public static void emptyHashTable() {
        //empty the hash table
        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i] = new PratikValueEntry();
        }
        for (int i = 0; i < tableCapacity; i++) {
            workingHashTable[i].setKey(-1);
        }
    }

    public static void main(String[] args) {
        //header("Pratik Demo Hashing With All Open Addressing Techniques");
        myHeader(3, 2, "Pratik Gupta", "Pratik Demo Hashing With All Open Addressing Techniques");

        System.out.println("""
                Welcome to the demo of hashing with all open addressing techniques.
                This program will demonstrate the working of the following techniques:
                1. Linear Probing
                2. Quadratic Probing
                3. Double Hashing
                
                Enter 1 for Sample output 1
                Enter 2 for Sample output 2
                Enter 3 to enter your own data set
                """);
        int dataSet;
        do {
            dataSet = getInt("So, which option do you want?", 1); //This will be used to select the dataset; set it 1 for sample output 1 and 2 for sample output 2. If you set it to 3, you will be asked to enter the data set.
        }
        while (dataSet < 1 || dataSet > 3);
        System.out.println();

        switch (dataSet) {
            case 1 -> {
                items = 5;
                loadFactor = 0.5;
                System.out.println(green + "Sample Output 1" + reset);
                System.out.println("Number of items: " + items);
                System.out.println("Load factor: " + loadFactor);
                int[] dataSet1 = {11, 22, -33, -44, 55};
                performOperation(dataSet1); //perform the operation
            }
            case 2 -> {
                items = 5;
                loadFactor = 0.75;
                System.out.println(green + "Sample Output 2" + reset);
                System.out.println("Number of items: " + items);
                System.out.println("Load factor: " + loadFactor);
                int[] dataSet2 = {7, 14, -21, -28, 35};
                performOperation(dataSet2); //perform the operation
            }
            case 3 -> {
                System.out.println(green + "Create your own DataSet" + reset);
                items = getInt("How many items are there in the dataset", 1);
                loadFactor = getDouble("Enter the load factor (Recommended: <= 0.5)");
                int[] dataSet3 = new int[items]; //create the array
                //get the data set from the user
                for (int i = 0; i < items; i++) {
                    dataSet3[i] = getInt("Enter the value for item " + (i + 1), 1);
                }
                performOperation(dataSet3); //perform the operation
            }
        }

        //Calling myFooter() method
        myFooter(3, 2);
    }

    //Thank You are teaching me this course
}
