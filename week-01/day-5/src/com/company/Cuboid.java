package com.company;

import static java.lang.Math.round;

public class Cuboid {
    public static void main(String[] args) {
        double x = 10;
        double y = 10;
        double z = 10;

        double surfaceArea = (2 * x * y + 2 * x * z + 2 * y * z);
        double volume = (x * y * z);

        System.out.println(Math.round(surfaceArea));
        System.out.println(Math.round(volume));
    }
}

// Write a program that stores 3 sides of a cuboid as variables (doubles)
// The program should write the surface area and volume of the cuboid like:
//
// Surface Area: 600
// Volume: 1000