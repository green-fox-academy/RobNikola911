package com.company;

public class ArraysExerciseAppendA {
    public static void main(String[] args) {
        String[] animals = {"koal", "pand", "zebr"};

        for (int elementsOfArray = 0; elementsOfArray < animals.length; elementsOfArray++) {
            animals[elementsOfArray] = animals[elementsOfArray] + "a";
            System.out.print(animals[elementsOfArray] + " ");
        }
    }
}
// - Create an array variable named `animals`
//   with the following content: `["koal", "pand", "zebr"]`
// - Add all elements an `"a"` at the end