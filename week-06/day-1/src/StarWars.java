import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StarWars {
    public static void main(String[] args) {
        Stream<String> rows;
        try {
            rows = Files.lines(Paths.get("src/swcharacters.csv"));
        } catch (IOException ioe) {
            System.out.println("No such file!");
            return;
        }
        Map<String, Integer> map = new HashMap<>();
        map = rows
                .map(x -> x.split(";"))
                .skip(1)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])));
        rows.close();
        for (String key : map.keySet()) {
            System.out.println(key + "  " + map.get(key));
        }
    }
}
