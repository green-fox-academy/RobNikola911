package meeting;

import java.util.*;

public class Meeting {

    public Meeting() {
    }

    public String meeting(String s) {
        String[] guests = s.split(";");
        for (int i = 0; i < guests.length; i++) {
            int index = guests[i].indexOf(":");
            guests[i] = "(" + guests[i].substring(0, index).toUpperCase() + ", " + guests[i].substring(index + 1).toUpperCase() + ")";
        }
        Arrays.sort(guests);

        return String.join("\n", guests);
    }

    public static void main(String[] args) {
        Meeting meeting2 = new Meeting();
        System.out.println(meeting2.meeting("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill"));
    }

}