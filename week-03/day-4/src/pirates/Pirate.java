package pirates;

import java.util.ArrayList;
import java.util.Random;

public class Pirate {
    protected int intoxicationLevel;
    protected String name;
    protected int health;
    protected boolean isDead;
    protected boolean isPassedOut;
    protected Parrot parrot;


    public Pirate(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public Pirate(int intoxicationLevel) {
        this.intoxicationLevel = intoxicationLevel;
    }

    public Pirate() {
        this.parrot = new Parrot();
    }

    public void drinkSomeRum() {

        if (!this.isDead) {
            this.intoxicationLevel++;
        } else {
            System.out.println("The pirate is dead!");
        }
    }

    public void howsItGoingMate() {
        if (intoxicationLevel < 5) {
            System.out.println("Pour me anudder!");
        } else {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
        }
    }

    public void die() {
        this.isDead = true;
    }

    public void passOut() {
        this.isPassedOut = true;
    }

    public void brawl(Pirate pirate) {
        ArrayList<Integer> chances = new ArrayList<>();
        chances.add(1); //one dies
        chances.add(0); // both passes out
        chances.add(-1); // the other dies
        Random random = new Random();
        if (!pirate.isDead) {
            for (int i = 0; i < chances.size(); i++) {
                if (chances.get(random.nextInt(chances.size())) == 1) {
                    pirate.die();
                } else if (chances.get(random.nextInt(chances.size())) == 0) {
                    pirate.passOut();
                    this.passOut();
                } else {
                    this.die();
                }
            }
        } else {
            System.out.println("This pirate is dead!");
        }

    }
}
