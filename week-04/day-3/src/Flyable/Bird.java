package Flyable;

import Zoo.Animal;

public class Bird extends Animal implements Flyable {


    public Bird(String name, int age, String gender) {
        super(name, age, gender);
    }

    public Bird(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "laying eggs.";
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
