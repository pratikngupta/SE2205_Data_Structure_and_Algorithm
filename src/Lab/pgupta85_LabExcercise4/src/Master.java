import Q1.PratikExerciseOnFileMapSet;

import java.io.FileNotFoundException;

import static Method.Intro.*;


public class Master {

    public static void main (String [] args) {

        int choice;

        do {
            myHeader(3,1,"Pratik Gupta","Master");
            System.out.println(purple + "1. Exercise on File, Map and Set" + reset);
            System.out.println("2. Exit" +reset);
            choice = getInt("Enter your choice", 1);

            switch (choice) {
                case 1 -> {
                    PratikExerciseOnFileMapSet.main(args);
                    break;
                }
                case 2 -> {
                    myFooter(3,1);
                    System.out.println("Thank you for using my program!");
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 2);

    }


}
