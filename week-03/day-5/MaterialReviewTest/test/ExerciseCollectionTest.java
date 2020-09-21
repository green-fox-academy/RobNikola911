import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExerciseCollectionTest {

    private ExerciseCollection ec;

    @BeforeEach
    public void init() {
        ec = new ExerciseCollection();
    }

    @Test
    public void replaceDishwasherHappyCase() {
        String sentence = "Test dishwasher sentence";
        String wordToReplace = "galaxy";
        String expected = "Test galaxy sentence";
        Assertions.assertEquals(expected, ec.replaceDishwasher(sentence, wordToReplace));
    }

    @Test
    public void replaceDishwasherSentenceNull() {
        String wordToReplace = "galaxy";
        Assertions.assertEquals("", ec.replaceDishwasher(null, wordToReplace));
    }

    @Test
    public void replaceDishwasherWordNull() {
        String sentence = "Test dishwasher sentence";
        String wordToReplace = "galaxy";
        String expected = "Test dishwasher sentence";
        Assertions.assertEquals(expected, ec.replaceDishwasher(sentence, null));
    }

    @Test
    public void fileReadingHappyCase() {
        String filename = "asd";
        Assertions.assertTrue(ec.fileReading(filename));
    }

    @Test
    public void fileReadingNotExistingFile() {
        String filename = "invalidFile";
        Assertions.assertFalse(ec.fileReading(filename));
    }

    @Test
    public void fileReadingNullFile() {
        Assertions.assertFalse(ec.fileReading(null));
    }

    //just for interest
    @Test
    public void fileReadingWithExceptionThrowsIOException() {
        Assertions.assertThrows(IOException.class, () -> {
            ec.fileReadingException("fdsfsdgf");
        });
    }

    @Test
    public void getArrayListHappyCase() {
        //we can have more assertions in test
        // it will passed only if all assertions are passed

        //check ArrayList size
        int limit = 10;
        Assertions.assertTrue(ec.getArrayList(limit).size() > 0);
        Assertions.assertTrue(ec.getArrayList(limit).size() == limit);
        Assertions.assertTrue(Integer.valueOf(ec.getArrayList(limit).size()) != null);
    }

    @Test
    public void getArrayListNegativeNumber() {
        int limit = -10;
        Assertions.assertEquals(10, ec.getArrayList(limit).size());
    }
}