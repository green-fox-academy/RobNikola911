package aircraftcarriers;

import java.util.ArrayList;
import java.util.List;

public class Carrier {

    protected List<AbstractAC> listOfPlanes;
    protected int storeOfAmmo;
    protected int hp;
    protected int totalDamage;

    public Carrier(int storeOfAmmo, int hp) {
        listOfPlanes = new ArrayList<>();
        this.storeOfAmmo = storeOfAmmo;
        this.hp = hp;
        totalDamage = 0;
    }


    public void add(AbstractAC ac1){
        listOfPlanes.add(ac1);
    }

    public void fillAllACs(){
        for (int i = 0; i < listOfPlanes.size(); i++){
            if (storeOfAmmo == 0){
                break;
            } else {
                storeOfAmmo = listOfPlanes.get(i).refill(storeOfAmmo);
            }
        }
    }

    public String getStatus() {
        String str = "HP: " + hp + ", Aircraft count: " + listOfPlanes.size() + ", Ammo Storage: "
                + storeOfAmmo + ", Total damage: " + totalDamage + "\n";
        str += "Aircrafts:\n";
        for (int i = 0; i < listOfPlanes.size(); i++) {
            str += listOfPlanes.get(i).getStatus() + "\n";
        }
        return str;
    }
}