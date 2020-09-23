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
        System.out.println("Quick landing...");
    }

    @Override
    public void fly() {
        System.out.println("Wings flapping...");
    }

    @Override
    public void takeOff() {
        System.out.println("Like a bird...");
    }
}
