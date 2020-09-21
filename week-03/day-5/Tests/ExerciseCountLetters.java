import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ExerciseCountLetters {
    CountLetters countLetters;

    @BeforeEach
    public void init() {
        this.countLetters = new CountLetters();
    }
    @Test
    public void countLettersHappyCase () {
        String word = "testtext:2,newtest:1";
        Map<String, Integer> expected = new HashMap<>();
        expected.put("testtext", 2);
        expected.put("newtest" , 1);

        Assertions.assertEquals(expected, countLetters.dictionary(word));

    }
}
