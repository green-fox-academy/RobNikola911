package aircraftcarriers;

public class Aircraft {
    protected String type;
    protected int maxAmmo;
    protected int aircraftDamage;
    protected int currentAmmo;
    protected int damageDealt;


    public Aircraft(String type) {
        if (type.equals("F16")) {
            maxAmmo = 8;
            aircraftDamage = 30;
        } else {
            maxAmmo = 12;
            aircraftDamage = 50;
        }
        this.type = type;
        currentAmmo = 0;
        damageDealt = 0;
    }

    public int fight() {
        int damage = aircraftDamage * currentAmmo;
        damageDealt += damage;
        currentAmmo = 0;
        return damage;
    }

    public int refill(int fillAmmo) {
//        It should take a number as parameter and subtract as much ammo as possible
//        It can't have more ammo than the number or the max ammo (can't get more ammo
//        than what's coming from the parameter or the max ammo of the aircraft)
//        It should return the remaining ammo
//        Eg. Filling an empty F35 with 300 would completely fill the storage of the aircraft and
//        would return the remaining 288

        int missingAmmo = this.maxAmmo - this.currentAmmo;
        if (missingAmmo > fillAmmo) {
            this.currentAmmo = this.currentAmmo + missingAmmo;
            fillAmmo -= missingAmmo;
        } else {
            this.currentAmmo += fillAmmo;
            return 0;
        }

        return fillAmmo - missingAmmo;
    }

    public String getType() {
        return type;

    }

    public String getStatus() {
        //        It should return a string like: Type F35, Ammo: 10, Base Damage: 50, All Damage: 500
        return "Type " + getType() + ", Ammo: " + this.currentAmmo + " Base Damage: "
                + this.aircraftDamage + ", All Damage: " + this.damageDealt;
    }

    public boolean isPriority() {
//        It should return if the aircraft is priority in the ammo fill queue. It's true for F35 and false for F16
        return this.getType().equals("F35");
    }
}
