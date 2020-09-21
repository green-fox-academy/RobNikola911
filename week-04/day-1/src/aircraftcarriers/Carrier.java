package aircraftcarriers;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
    protected List<Aircraft> storedAircrafts;
    protected int ammoStorage;
    protected int initialAmmo;
    protected int HP;

    public Carrier(){

    }

    public Carrier(int initialAmmo){
        this.storedAircrafts = new ArrayList<>();
        this.ammoStorage = 2300;
        this.initialAmmo = initialAmmo;
        this.HP = 5000;
    }

    public void add() {
        storedAircrafts.add(new Aircraft());
    }
    public void fill() {
        for (Aircraft aircraft: storedAircrafts) {
            aircraft.refill(ammoStorage);

        }
    }
}
