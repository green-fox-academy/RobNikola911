package Flyable;

public class FlyingMain {
    public static void main(String[] args) {
        Helicopter helicopter = new Helicopter("PF-345","White",2008 );
        stepsOfFly(helicopter);
        System.out.println(helicopter.toString());

        Bird bird = new Bird("Eagle", 2, "female");
        stepsOfFly(bird);


    }
    public static void stepsOfFly(Flyable flyable){
        flyable.takeOff();
        flyable.fly();
        flyable.land();
    }
}
