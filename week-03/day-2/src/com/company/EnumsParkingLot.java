package com.company;

public class EnumsParkingLot {

    public enum CarTypes {
        FORD("Green"), BMW("Red"), MERCEDES("Blue"), OPEL("Yellow");

        private final String value;

        private CarTypes(String value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        System.out.println(CarTypes.BMW);
    }
}




/*
    Parking Lot
    Create a Car class with 2 enum properties enum of car types
    The types of these cars or vehicles is up to you
    enum of colors
        Create 256 Vehicles randomly and put them into a List
        Count and Print the number of same vehicles for each type
        Count and Print the number of same vehicles for each color
        Print the most frequently occurring vehicle*/
