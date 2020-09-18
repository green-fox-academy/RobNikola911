import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExerciseSumTest {
    private Sum sum;
    private List<Integer> myList;

    @BeforeEach
    public void init() {
        sum = new Sum();
        myList = new ArrayList<>();
    }

    @Test
    public void intSumHappyCase() {
        myList.add(5);
        myList.add(22);
        myList.add(33);

        int expected = 60;
        Assertions.assertEquals(expected, sum.sumOfIntegers(myList));
    }

    @Test
    public void intSumEmptyList() {
        int expected = 0;
        Assertions.assertEquals(expected, sum.sumOfIntegers(myList));
    }

    @Test
    public void intSumOneElement() {
        myList.add(12);
        int expected = 12;
        Assertions.assertEquals(expected, sum.sumOfIntegers(myList));
    }

    @Test
    public void intSumOneNull() {
        myList = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            sum.sumOfIntegers(myList);
        });
//        Assertions.assertEquals(expected, sum.sumOfIntegers(myList));

    }
}



/*
    Add a new test case
    Instantiate your class
    create a list of integers
                    use the assertEquals to test the result of the created sum method*/
