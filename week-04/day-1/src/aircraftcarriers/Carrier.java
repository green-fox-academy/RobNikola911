package aircraftcarriers;

import java.util.ArrayList;
import java.util.List;

public class Carrier {

    protected List<Aircraft> storedAircrafts;
    protected int ammoStorage;
    protected int initialAmmo;
    protected int HP;

    public Carrier() {
        this.storedAircrafts = new ArrayList<>();
        this.ammoStorage = 2300;
        this.initialAmmo = 100;
        this.HP = 5000;
    }

    public Carrier(int initialAmmo) {
        this.storedAircrafts = new ArrayList<>();
        this.ammoStorage = 2300;
        this.initialAmmo = initialAmmo;
        this.HP = 5000;
    }

    public void add(Aircraft aircraft) {
        storedAircrafts.add(aircraft);
    }

    public void fill() throws Exception {
        for (Aircraft aircraft : storedAircrafts) {
            aircraft.setAmmunition(aircraft.maxAmmo);
            ammoStorage -= aircraft.maxAmmo - aircraft.getAmmunition();
        }
        for (Aircraft aircraft : storedAircrafts) {
            if (ammoStorage < aircraft.maxAmmo - aircraft.getAmmunition()) {
                if (aircraft.isPriority()) {
                    aircraft.refill(ammoStorage);
                }
            }
        }
        for (Aircraft aircraft : storedAircrafts) {
            if (ammoStorage < aircraft.maxAmmo - aircraft.getAmmunition()) {
                if (!aircraft.isPriority()) {
                    aircraft.refill(ammoStorage);
                }
            }
        }
        if (ammoStorage == 0) {
            throw new Exception("There is no ammo left!");
        }
    }

    public int getTotalDamage() {
        int totalDamage = 0;
        for (Aircraft aircraft : storedAircrafts) {
            totalDamage += aircraft.currentAmmo * aircraft.baseDamage;
        }
        return totalDamage;
    }

    public void fight(Carrier carrier) {
        HP -= getTotalDamage();
    }

    public void getStatus() {
        System.out.print("HP: " + this.HP + " , Aircraft count: " + storedAircrafts.size() + ", Ammo " +
                "storage: " + ammoStorage + " , Total damage: " + getTotalDamage() + "\n " + " Aircrafts: \n ");
        for (Aircraft aircraft : storedAircrafts) {
            System.out.println(aircraft.getStatus());
        }
    }
}