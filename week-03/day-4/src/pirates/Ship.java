package pirates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship extends Pirate {

    protected List<Pirate> crew;
    protected Pirate captain;
    protected int crewNumber;
    protected Random random = new Random();

    public Ship(List<Pirate> crew, Pirate captain) {
        this.crew = crew;
        this.captain = captain;
    }

    public void fillShip() {
        crewNumber = random.nextInt(10) + 1;
        crew.add(captain);
        for (int i = 0; i < crewNumber; i++) {
            crew.add(new Pirate());
        }
    }

    public void status() {
        System.out.println(
                "The Captain is alive and he consumed " + " rum(s).");
        System.out.println("The Captain is passed out or dead.");

    }
}
