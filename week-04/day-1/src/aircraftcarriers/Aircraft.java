package aircraftcarriers;

public class Aircraft {

    protected int currentAmmo;
    protected int baseDamage;
    protected int maxAmmo;
    protected String type;

    public Aircraft() {
    }

    public Aircraft(int currentAmmo, int baseDamage, int maxAmmo) {
        this.currentAmmo = 0;
        this.baseDamage = 0;
        this.maxAmmo = 0;
    }

    public int getAmmunition() {
        return currentAmmo;
    }

    public void setAmmunition(int currentAmmo) {
        this.currentAmmo = currentAmmo;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int fight() {
        int totalDamage = baseDamage * currentAmmo;
        setAmmunition(0);
        return totalDamage;
    }

    public int refill(int storeOfAmmo) {
        if (storeOfAmmo > maxAmmo)
            for (int i = 0; i < (maxAmmo - currentAmmo); i++) {
                storeOfAmmo -= maxAmmo;
            }
        else {
            for (int i = 0; i < storeOfAmmo; i++) {
                storeOfAmmo--;
            }
        }
        return storeOfAmmo;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return "Type: " + getType() + " , Ammo: " + getAmmunition() + " , Base damage: "
                + getBaseDamage() + " , All " + "damage: " + fight();
    }

    public Boolean isPriority() {
        return true;
    }
}