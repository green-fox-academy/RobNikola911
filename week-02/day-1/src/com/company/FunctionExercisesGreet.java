package com.company;

public class FunctionExercisesGreet {
    public static void main(String[] args) {
        String al = "Green Fox";
//        String greetings = greet(al);
        System.out.println(greet(al));
    }

    public static String greet(String greeter) {
        greeter = "Greetings dear, " + greeter;
        return greeter;
    }
}


// - Create a string variable named `al` and assign the value `Green Fox` to it
// - Create a function called `greet` that greets it's input parameter
//     - Greeting is printing e.g. `Greetings dear, Green Fox`
// - Greet `al`