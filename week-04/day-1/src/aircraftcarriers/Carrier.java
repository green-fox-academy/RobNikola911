package aircraftcarriers;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
    protected List<Aircraft> storedAircrafts;
    protected int ammoStorage;
    private int totalAmmo;
    protected int HP;

    public Carrier() {

    }

    public Carrier(int ammoStorage, int HP) {
        this.ammoStorage = ammoStorage;
        this.HP = HP;
        storedAircrafts = new ArrayList<>();
    }

    public void add(Aircraft aircraft) {
        storedAircrafts.add(aircraft);
    }

    public void fill() throws Exception {
        if (ammoStorage == 0) {
            throw new Exception("No more ammo, need refill");
        }
        this.totalAmmo = 0;

        for (Aircraft aircraft : storedAircrafts) {
            totalAmmo += aircraft.maxAmmo - aircraft.currentAmmo;
        }

        if (totalAmmo > ammoStorage) {
            for (Aircraft aircraft : storedAircrafts) {
                if (aircraft.isPriority()) {
                    ammoStorage = aircraft.refill(ammoStorage);
                }
            }
        }
        for (Aircraft aircraft : storedAircrafts) {
            ammoStorage = aircraft.refill(ammoStorage);
        }
    }

    public void getStatus() {
        int totalDamage = 0;
        for (Aircraft aircraft : storedAircrafts) {
            totalDamage += aircraft.damageDealt;
        }
        System.out.println("HP: " + storedAircrafts.size() * 1000 + ", Aircraft count: " + storedAircrafts.size() +
                ", Ammo Storage: " + ammoStorage + ", Total Damage: " + totalDamage);
        for (Aircraft aircraft : storedAircrafts) {
            System.out.println(aircraft.getStatus());
        }
    }
}
