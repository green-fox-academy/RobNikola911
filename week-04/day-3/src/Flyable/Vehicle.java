package Flyable;

public abstract class Vehicle {
    protected String model;
    protected String color;
    protected int year;

    public Vehicle(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }
}
