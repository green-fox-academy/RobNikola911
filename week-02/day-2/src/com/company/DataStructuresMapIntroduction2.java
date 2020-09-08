package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DataStructuresMapIntroduction2 {
    public static void main(String[] args) {

        HashMap<String, String> myMap = new HashMap<String, String>();
        myMap.put("978-1-60309-452-8", "A Letter to Jo");
        myMap.put("978-1-60309-459-7", "Lupus");
        myMap.put("978-1-60309-444-3", "Red Panda and Moon Bear");
        myMap.put("978-1-60309-461-0", "The Lab");

        Set<Map.Entry<String, String>> entries = myMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.print(entry.getValue() + " (ISBN: ");
            System.out.println(entry.getKey() + ")");
//            System.out.println(String.format("%s (ISBN: %s)", entry.getValue(), entry.getKey()));;
        }

        myMap.remove("978-1-60309-444-3");
        myMap.values().remove("The Lab");
//      System.out.println(myMap);
        myMap.put("978-1-60309-450-4", "They Called Us Enemy");
        myMap.put("978-1-60309-453-5", "Why Did We Trust Him?");
        System.out.println("Key 478-0-61159-424-8 is associated: " + myMap.containsKey("478-0-61159-424-8"));
        System.out.println(myMap.get("978-1-60309-453-5") + " We don't know...");

    }
}
//    Remove the key-value pair with key 978-1-60309-444-3
//    Print whether there is an associated value with key 478-0-61159-424-8 or not
//    Print the value associated with key 978-1-60309-453-5