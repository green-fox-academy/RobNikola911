import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExerciseCollection {
    //Simple Replace
    public String replaceDishwasher(String sentence, String wordToReplace) {
        if (sentence == null) {
            return "";
        }
        if (wordToReplace == null) {
            return sentence;
        }
        return sentence.replace("dishwasher", wordToReplace);
    }

    //File reading
    public Boolean fileReading(String filename) {
        if (filename == null) {
            return false;
        }
        Path path = Paths.get("src/" + filename + ".txt");
        Boolean isSuccess = false;
        try {
            List<String> lines = Files.readAllLines(path);
            isSuccess = true;
            return isSuccess;
        } catch (IOException e) {
            return isSuccess;
        }
    }

    //File reading with exception
    public List<String> fileReadingException (String filename) throws IOException {
        Path path = Paths.get("src/" + filename + ".txt");

        return Files.readAllLines(path);
    }


    //ArrayList adding
    public ArrayList<Integer> getArrayList(int limit) {
        if (limit < 0) {
            limit = Math.abs(limit);
            //limit *= -1;
        }
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i=0; i<limit; i++) {
            numbers.add(i);
        }
        return numbers;
    }

}