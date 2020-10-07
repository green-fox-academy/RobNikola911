package filereaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {
    public static void main(String[] args) {

        Path pathFrom = Paths.get("assets/rob.txt");
        Path pathTo = Paths.get("assets/text.txt");
        //Path createNew = Paths.get("assets/text2.txt");
        Path hello2 = Paths.get("assets/hello2.txt");

        try {
            List<String> fromFile = Files.readAllLines(pathFrom);
            List<String> toFile = new ArrayList<>();
            toFile.add(fromFile.get(0));
            Files.write(pathTo,toFile, StandardOpenOption.APPEND);
            //Files.write(createNew,toFile,StandardOpenOption.CREATE_NEW);
            String str = Files.readString(hello2);
            System.out.println(str);
            toFile.add(str);
            Files.write(pathTo,toFile, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}