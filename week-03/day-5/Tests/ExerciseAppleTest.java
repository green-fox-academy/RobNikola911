import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExerciseAppleTest {
    private Apples at;

    @BeforeEach
    public void init() {
        at = new Apples();
    }

    @Test
    public void stringApplesHappyCase() {
        String expected = "Apple";
        Assertions.assertEquals(expected, at.getApple());
    }


}
