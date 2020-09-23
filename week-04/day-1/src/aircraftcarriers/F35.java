package aircraftcarriers;

public class F35 extends Aircraft {

    public F35() {
        this.maxAmmo = 12;
        this.baseDamage = 50;
        this.type = "F35";
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public void setMaxAmmo(int maxAmmo) {
        this.maxAmmo = maxAmmo;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    @Override
    public Boolean isPriority() {
        return true;
    }
}