package aircraftcarriers;

public class Aircraft {
    protected AircraftType aircraftType;
    protected int maxAmmo;
    protected int aircraftDamage;
    protected int currentAmmo;


    public Aircraft() {
        this.currentAmmo = 0;
    }
    public void damageDealt(){
        this.aircraftDamage = fight();
    }

    public int fight() {
        int damage = this.aircraftDamage * this.currentAmmo;
        currentAmmo = 0;
        return damage;
    }

    public int refill(int fillAmmo) {
        int missingAmmo = maxAmmo - currentAmmo;
        int remainingAmmo = fillAmmo - missingAmmo;
        this.currentAmmo = currentAmmo + missingAmmo;
        return remainingAmmo;
    }

    public String getType() {
        return aircraftType.toString();

    }

    public String getStatus() {
        String status = "Type " + aircraftType + ", Ammo: " + currentAmmo + " Base Damage: " + aircraftDamage
        + ", All Damage: " + fight();
//        It should return a string like: Type F35, Ammo: 10, Base Damage: 50, All Damage: 500
        return status;
    }

    public boolean isPriority() {
//        It should return if the aircraft is priority in the ammo fill queue. It's true for F35 and false for F16
        return true;
    }
}
