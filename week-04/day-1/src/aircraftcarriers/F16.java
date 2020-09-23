package aircraftcarriers;

public class F16 extends Aircraft {

    public F16() {
        this.maxAmmo = 8;
        this.baseDamage = 30;
        this.type = "F16";
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
        return false;
    }
}