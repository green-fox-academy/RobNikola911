package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataStructuresTelephoneBook {
    public static void main(String[] args) {
        HashMap<String, String> myPhone = new HashMap<String, String>();
        myPhone.put("William A. Lathan", "405-709-1865");
        myPhone.put("John K. Miller", "402-247-8568");
        myPhone.put("Hortensia E. Foster", "606-481-6467");
        myPhone.put("Amanda D. Newland", "319-243-5613");
        myPhone.put("Brooke P. Askew", "307-687-2982");

        System.out.println("John K. Miller's phone number is: " + myPhone.get("John K. Miller"));


        Optional<String> value = myPhone.entrySet()
                .stream()
                .filter(s -> s.getValue().equals("307-687-2982"))
                .map(Map.Entry::getKey)
                .distinct()
                .findFirst();
        System.out.println("Key: " + value.orElse("No such key"));

        if (myPhone.get("Chris E. Myers") != null) {
            System.out.println(myPhone.get("Chris E. Myers"));
        } else {
            System.out.println("No such phone number");
        }
        }
    }
        /*What is John K. Miller's phone number?
        Whose phone number is 307-687-2982?
        Do we know Chris E. Myers' phone number?*/