package com.company;

public class Car {
    private CarColor color;
    private CarType type;

    public Car(CarColor color, CarType type) {
        this.color = color;
        this.type = type;
    }


    @Override
    public String toString() {
        return "Car{" +
                "color=" + color +
                ", type=" + type +
                '}';
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }
}
