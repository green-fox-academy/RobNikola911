package filereaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

//https://www.baeldung.com/java-file-options
public class ReadAndWriteSpecificLines {
    public static void main(String[] args) {

        Path pathFrom = Paths.get("assets/rob.txt");
        Path pathTo = Paths.get("assets/text.txt");
        try {
            List<String> fromFile = Files.readAllLines(pathFrom);
            List<String> toFile = new ArrayList<>();
            toFile.add(fromFile.get(5));
            Files.write(pathTo, toFile, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}