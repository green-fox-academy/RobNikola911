import java.util.ArrayList;
import java.util.List;


public class Sum {

    public int sumOfIntegers(List<Integer> integers) {

        int sumOfElements = 0;

        for (int i = 0; i < integers.size(); i++) {
            sumOfElements += integers.get(i);
        }

        return sumOfElements;
    }


}
/*
    Create a sum method in your class which has an ArrayList of Integers as parameter
        It should return the sum of the elements in the list*/
