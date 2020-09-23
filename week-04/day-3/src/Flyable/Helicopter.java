package Flyable;

public class Helicopter extends Vehicle implements Flyable {
    public Helicopter(String model, String color, int year) {
        super(model, color, year);
    }

    @Override
    public void land() {
        System.out.println("Landing...");
    }

    @Override
    public void fly() {
        System.out.println("Flying...");
    }

    @Override
    public void takeOff() {
        System.out.println("Taking off...");
    }
}
