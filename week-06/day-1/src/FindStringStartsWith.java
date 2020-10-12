import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindStringStartsWith {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Please give a letter: ");
        String ch = in.next();

        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI",
                "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");

        List<String> filteredCities = cities.stream()
                .filter(city -> city.startsWith(ch))
                .collect(Collectors.toList());
        System.out.println(filteredCities);
    }
}
