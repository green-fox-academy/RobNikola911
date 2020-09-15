package com.company;

import java.util.ArrayList;

public class EnumsParkingLot {

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            cars.add(new Car(CarColor.randomCarColor(), CarType.randomCarType()));
        }
        for (int i = 0; i < CarType.VALUES.size(); i++) {
            final CarType carType = CarType.VALUES.get(i);
            System.out.println("The number of " + carType + " type cars: "
                    + (int) cars.stream().filter(car -> car.getType() == carType).count());
        }
        for (int i = 0; i < CarColor.VALUES.size(); i++) {
            final CarColor carColor = CarColor.VALUES.get(i);
            System.out.println("The number of " + carColor + " color cars: " +
                    (int) cars.stream().filter(car -> car.getColor() == carColor).count());
        }
        Car frequentCar = null;
        long maxCount = 0;

        for (int i = 0; i < CarType.VALUES.size(); i++) {
            final CarType carType = CarType.VALUES.get(i);

            for (int j = 0; j < CarColor.VALUES.size(); j++) {
                final CarColor carColor = CarColor.VALUES.get(j);
                long counter = cars.stream()
                        .filter(car -> car.getType() == carType)
                        .filter(car -> car.getColor() == carColor)
                        .count();
                if (counter > maxCount) {
                    frequentCar = new Car(carColor, carType);
                    maxCount = counter;
                }

            }

        }
        System.out.printf("%s %d",frequentCar, maxCount);
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
