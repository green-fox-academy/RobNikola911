import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExerciseAnagramTest {
    Anagram anagram;

    @BeforeEach
    public void init() {
        this.anagram = new Anagram();
    }
    @Test
    public void anagramHappyCase() {
        String firstWord = "text Same";
        String secondWord = "Same text";

        Assertions.assertTrue(anagram.anagrams(firstWord, secondWord));
    }


}
