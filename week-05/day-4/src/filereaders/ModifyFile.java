package filereaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ModifyFile {
    public static void main(String[] args) {

        writeMultipleLines("assets/rob.txt", "modify and verify", 4);
    }

    public static void writeMultipleLines(String str, String str2, int in) {
        Path path = Paths.get(str);
        try {
            List<String> fromFile = Files.readAllLines(path);
            for (int i = 0; i < in; i++) {
                fromFile.add(str2 + " nr." + i);
            }
            Files.write(path, fromFile);

            String str3 = Files.readString(path);
            for (int i = 0; i < in; i++) {
                str3 += str2 + "\n";
            }
            Files.write(path, Collections.singleton(str3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}