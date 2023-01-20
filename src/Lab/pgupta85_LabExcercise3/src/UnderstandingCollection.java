package Lab.pgupta85_LabExcercise3.src;

import java.util.ArrayList;
import java.util.Collections;

public class UnderstandingCollection {


    public static void main(String[] args) {

        ArrayList<String> name = new ArrayList<>();

        name.add("Pratik Gupta");
        name.add("Harry Potter");
        name.add("Ronald Weasley");
        name.add("Hermione Granger");
        name.add("Parvati Patil");


        System.out.println(name);

        Collections.sort(name);

        System.out.println(name);





    }


}
