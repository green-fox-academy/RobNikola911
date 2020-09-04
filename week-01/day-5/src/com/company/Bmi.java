package com.company;

public class Bmi {
    public static void main(String[] args) {
        double massInKg = 110.2;
        double heightInM = 1.90;
        double squareHeight = Math.pow(heightInM, 2);
        double BMI = (massInKg / squareHeight);
        System.out.println(BMI);
    }
}
// Print the Body mass index (BMI) based on these values