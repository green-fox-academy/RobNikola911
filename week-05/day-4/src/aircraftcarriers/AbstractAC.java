package aircraftcarriers;

abstract class AbstractAC {
    protected int maxAmmo;
    protected int damage;
    protected int remainingAmmo;
    protected int totalDamage;
    protected boolean isPriority;

    public AbstractAC() {
        this.maxAmmo = 0;
        this.damage = 0;
        this.remainingAmmo = 0;
        totalDamage = 0;
    }

    public int fight(){
        totalDamage += damage * remainingAmmo;
        return damage * remainingAmmo;
    }

    public int refill(int howMuch){
        if (howMuch > maxAmmo - remainingAmmo){
            int wasRemaining = remainingAmmo;
            remainingAmmo = maxAmmo;
            return howMuch - maxAmmo - wasRemaining;
        } else {
            remainingAmmo += howMuch;
            return 0;
        }
    }

    public String getType(){
        return getClass().getSimpleName();
    }

    public String getStatus(){
        return "Type: " + getType() + ", Ammo " + remainingAmmo + ", Base Damage: "
                + damage + ", All Damage: " + totalDamage;
    }

}