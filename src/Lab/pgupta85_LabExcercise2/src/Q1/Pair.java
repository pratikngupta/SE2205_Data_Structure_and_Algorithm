/*************************************************************************************************************************
 * Name: Pratik Narendra Gupta
 * Student ID: 251211859
 * Date: 1st October
 * Task: Create generic class Pair which will take two generic type of data and will return the data in form of pair.
 *************************************************************************************************************************/

package Lab.pgupta85_LabExcercise2.src.Q1;

public class Pair<Y,N> {
    private Y key;
    private N value;

    //Creating constructor of Pair class, which will accept two generic type of data
    public Pair(Y key, N value) {
        this.key = key;
        this.value = value;
    }

    //setter method for key
    public void setKey(Y key) {
        this.key = key;
    }

    //getter method for key
    public void setValue(N value) {
        this.value = value;
    }

    //getter method for value
    public N getValue() {
        return value;
    }

    //getter method for key
    public Y getKey() {
        return key;
    }
}
