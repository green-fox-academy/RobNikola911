package com.company;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DataStructuresMapIntroduction1 {
    public static void main(String[] args) {

        HashMap<Integer, String> myMap = new HashMap<Integer, String>();
        System.out.println("Is HashMap Empty? " + myMap.isEmpty());

        myMap.put(97, "a");
        myMap.put(98, "b");
        myMap.put(99, "c");
        myMap.put(65, "A");
        myMap.put(66, "B");
        myMap.put(67, "C");

        Set<Integer> keys = myMap.keySet();
        for (Integer key : keys) {
            System.out.print(key + " ");
        }

        Collection<String> values = myMap.values();
        for (String value : values) {
            System.out.print(value + " ");
        }
        myMap.put(68, "D");

        Set<Map.Entry<Integer, String>> entries = myMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.print("key: " + entry.getKey());
            System.out.println(", Value: " + entry.getValue());
        }

        String val = myMap.get(99);
        System.out.println("The Value mapped to Key 99 is: " + val);

        myMap.remove(97);

        System.out.println("This hashMap has the key 100: " + myMap.containsKey(100));

        myMap.clear();
        System.out.println("Clear all values: " + myMap);


//        for (var any: hash.values()) {
//            System.out.println(any);
//        }
    }
}
