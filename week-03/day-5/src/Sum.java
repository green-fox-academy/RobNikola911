import java.util.ArrayList;


public class Sum {

    public ArrayList<Integer> getArrayList(int integers) {

        ArrayList<Integer> numbers = new ArrayList<>();
        int sumOfElements = 0;
        for (int i = 0; i < getArrayList(integers).size(); i++) {
           sumOfElements += getArrayList(integers).get(i);
        }

        return getArrayList(integers);
    }


}
/*
    Create a sum method in your class which has an ArrayList of Integers as parameter
        It should return the sum of the elements in the list*/
