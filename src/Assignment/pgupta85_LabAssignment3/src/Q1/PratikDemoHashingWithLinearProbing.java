/***********************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Date: 27 Nov 2022
 * Student ID: 251211859
 * Task: learn about hashing
 * What will this code do?
 * 1) This code will create a hash table; and will insert, delete, search and print the hash table.
 * 2) It will also print the hash table.
 * It will be using linear probing to resolve collision.
 **********************************************************************************************************************/

package Assignment.pgupta85_LabAssignment3.src.Q1;

import static Assignment.pgupta85_LabAssignment3.src.Method.Intro.*;

public class PratikDemoHashingWithLinearProbing {

    //Number of items in the hash table
    //loadFactor:  0.0 to 1 : purpose of load factor is to determine when to increase the size of the hash table
    //This will be used to store the size of table.
    //Array of PratikValueEntry type
    //Array of PratikValueEntry type
    public static int items;
    public static double loadFactor;
    public static int tableCapacity;
    public static PratikValueEntry[] hashTable;
    public static PratikValueEntry[] workingHashTable;

    //addValue method will accept integer value and will add it to the hash table.
    public static void addValueLinearProbe(int key){
        int index = getIndex(tableCapacity, hashTable, key); //This will give us the index where we need to store the value.
        if (index != -1){
            hashTable[index] = new PratikValueEntry(key);
        }
        hashTable[index].setKey(key); //set the key
    }

    //This method will accept integer value check if it is prime or not. If it is not prime, it will increase the value by 1 and will check again.
    public static int checkPrime(int n){
        //This will check if the number is prime or not.
        int m = n/2;
        //If the number is even, it will increase the number by 1 and will check again.
        for (int i = 3; i <= m; i++) {
            if (n % i == 0) {
                i = 2;
                n++;
                m = n/2;
            }
        }
        return n; //This will return the prime number.
    }

    //Define a public static void method removeValueLinearProbe(Integer), which will accept an integer key, search through the hash table using linear probing technique and if it finds the key, it will remove it by replacing the key with -111 value as a flag for ‘available’ location, otherwise it will print a message that the key is not found
    public static void removeValueLinearProbe(int key){
        boolean found = false; //flag to check if the key is found or not.
        int index = key % tableCapacity; //This will give us the index to first check.
        if (index < 0){
            index = index + tableCapacity;
        }
        //This will check if the key is at predicate index or not.
        if (hashTable[index].getKey() == key){
            hashTable[index].setKey(-111);
            System.out.printf(green + "After removing %d, the hash table is: ", key, reset);
            printHashTable();
            System.out.println();
            found = true;
        } else {
            //This will check if the key is present in the hash table or not.
            for (int i = index + 1; i < tableCapacity; i++) {
                if (hashTable[i].getKey() == key){
                    hashTable[i].setKey(-111);
                    System.out.printf(green + "After removing %d, the hash table is: ", key, reset);
                    printHashTable();
                    System.out.println();
                    found = true;
                    break;
                }
            }
        }
        if (!found){
            System.out.printf( red +  "Key %d is not found in the hash table: ", key, reset);
            printHashTable();
            System.out.println();
        }
    }

    //Define a public static void method called rehashingWithLinearProbe() which will rehash the table according to rehashing technique discussed in the class.
    public static void rehashingWithLinearProbe(){
        //also account for negative value of key in the table.
        //create a new table with double the size of the current table. Account for the prime number.
        int newTableCapacity = checkPrime(tableCapacity * 2);

        //initialize the table with -1
        for (int i = 0; i < newTableCapacity; i++) {
            workingHashTable[i] = new PratikValueEntry();
        }

        //copy the values from the old table to the new table
        for (int i = 0; i < tableCapacity; i++) {
            if(hashTable[i].getKey() != -1 && hashTable[i].getKey() != -111){
                //get the index of the new table
                int index = getIndex(newTableCapacity, workingHashTable, hashTable[i].getKey());
                //set the key
                workingHashTable[index].setKey(hashTable[i].getKey());
            }
        }
        //assign the new table to the working table
        hashTable = workingHashTable;
        //assign the new table capacity to the tableCapacity field
        tableCapacity = newTableCapacity;
    }

    //Define a public static void method called getIndex() which will accept the table capacity, the hash table and the key, and will return the index where the key should be stored.
    public static int getIndex(int tableCapacity, PratikValueEntry[] hashTable, int key) {
        int index = key % tableCapacity; //This will give us the index where we need to store the value.
        if(index < 0){
            index += tableCapacity; //This will give us the index where we need to store the value.
        }
        if (index >= tableCapacity) {
            index = index % tableCapacity;
        }
        //find the index where the key should be stored
        while(hashTable[index].getKey() != -1 && hashTable[index].getKey() != -111){
            index++;
            if(index == tableCapacity){
                index = 0;
            }
        }
        return index; //This will return the index where we need to store the value.
    }

    //Define a public static void method printHashTable(), which will print the content of the hash table (see the sample output). In printing the keys, if the key is -1, this method will print null, and if the key is -111, it will print ‘available’.
    public static void printHashTable(){
        //also account for negative value of key in the table.
        System.out.printf(purple);
        System.out.print("[");

        //This will print the content of the hash table.
        for (int i = 0; i < tableCapacity; i++) {
            if(hashTable[i].getKey() == -1){ //If the key is -1, it will print null.
                System.out.print("null, ");
            }else if(hashTable[i].getKey() == -111){ //If the key is -111, it will print ‘available’.
                System.out.print("available, ");
            }else{
                System.out.print(hashTable[i].getKey()+", "); //If the key is not -1 or -111, it will print the key.
            }
        }
        //This will print the content of the hash table.
        System.out.println("\b\b]");
        System.out.printf(reset);
    }

    public static void staticData(int[] data){
        //add the data to the hash table using linear probing technique
        for (int i = 1; i <= data[0]; i++) {
            addValueLinearProbe(data[i]);
            System.out.println("Adding " + data[i] + " to the hash table: ");
        }

        System.out.print("\nThe hash table is: ");
        printHashTable();

        System.out.println();
        //remove the data from the hash table using linear probing technique: third last element of the data array
        removeValueLinearProbe(data[ data.length - 3 ]);

        //remove the data from the hash table using linear probing technique: second last element of the data array
        removeValueLinearProbe(data[ data.length - 2 ]);

        //add last element
        addValueLinearProbe(data[ data.length - 1 ]);
        System.out.printf("After adding %d to the hash table, the hash table is: ", data[ data.length - 1 ]);
        printHashTable();
    }

    //main method
    public static void main(String[] args) {
        int key;
        int dataSet;

        //header();
        myHeader(3, 1, "Pratik Narendra Gupta", "DemoHashingWithLinearProbing");

        System.out.println("""
                Welcome to the Hash Table Program!
                
                This program will create a hash table and will add, remove and search for the keys in the hash table.
                
                Enter 1 for Sample output 1
                Enter 2 for Sample output 2
                Enter 3 to enter your own data set
                """);

        do {
            dataSet = getInt("So, which option do you want?", 1); //This will be used to select the dataset; set it 1 for sample output 1 and 2 for sample output 2. If you set it to 3, you will be asked to enter the data set.
        }
        while (dataSet < 1 || dataSet > 3);
        System.out.println();

        System.out.println("Let's decide on the initial table capacity based on the load factor and dataset size");

        switch (dataSet) {
            case 1 -> {
                items = 5;
                loadFactor = 0.75;
                System.out.println("Number of items: " + items);
                System.out.println("Load factor: " + loadFactor);
            }
            case 2 -> {
                items = 5;
                loadFactor = 0.5;
                System.out.println("Number of items: " + items);
                System.out.println("Load factor: " + loadFactor);
            }
            case 3 -> {
                items = getInt("How many items are there in the dataset", 1);
                System.out.println("Number of items: " + items);
                loadFactor = getDouble("Enter the load factor (Recommended: <= 0.5)");
            }
        }

        //Calculate the table capacity
        tableCapacity = (int) (items/loadFactor);
        //Check if tableCapacity is prime
        tableCapacity = checkPrime(tableCapacity);
        System.out.println("The minimum required table capacity would be: " + tableCapacity + "\n");

        //Create the hash table
        hashTable = new PratikValueEntry[tableCapacity];

        //Initialize the hash table
        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i] = new PratikValueEntry();
        }

        //Create the working hash table
        workingHashTable = new PratikValueEntry[checkPrime(tableCapacity * 2)];

        //Initialize the working hash table
        for (int i = 0; i < tableCapacity; i++) {
            workingHashTable[i] = new PratikValueEntry();
        }

        //using switch case to select the dataset
        switch (dataSet) {
            case 1 -> { //dataset 1: run 1
                System.out.println("Using pre-defined data set 1");
                int[] data1 = {items, 13, 23, -12, 26, -43, -12, 26, 9};
                staticData(data1);
            }
            case 2 -> { //dataset 2: run 2
                System.out.println("Using pre-defined data set 2");
                int[] data2 = {items, -31, 13, -23, -21, 11, -31, 17, 21};
                staticData(data2);
            }
            case 3 -> { //dataset 3: Create your own dataset
                System.out.println("Enter the values to be added to the hash table");
                for (int i = 0; i < items; i++) {
                    System.out.println(items);
                    key = getInt("Enter the key value", 1);
                    addValueLinearProbe(key);
                }

                System.out.println("\nThe hash table is: ");
                printHashTable();
                System.out.println();

                //Remove the values from the hash table, using linear probing technique
                removeValueLinearProbe(getInt("Enter the key value to be removed", 1));

                //remove another value
                removeValueLinearProbe(getInt("Enter the key value to be removed", 1));

                //add to the hash table
                addValueLinearProbe(getInt("Enter the key value to be added", 1));
                System.out.print("After adding the value to the hash table, the hash table is: ");
                printHashTable();
            }
        }

        //Rehash the hash table
        rehashingWithLinearProbe();

        //Rehashed table capacity
        System.out.println("\nThe rehashed table capacity is: " + tableCapacity);
        System.out.println();

        //Print the hash table
        System.out.print("The hash table after rehashing is: ");
        printHashTable();

        //Footer method
        myFooter(3, 1);
    }

    //Thank You are teaching me this course
}
