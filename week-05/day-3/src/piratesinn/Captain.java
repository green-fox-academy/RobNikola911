package piratesinn;

import java.util.List;

public class Captain extends Pirate {

    //CONSTRUCTORS--------------------------
    public Captain(String name) {
        super(name);
        this.gold = (int)((Math.random() * 21) + 10) * 2;
        alcoholResilience = 2;
    }

    public Captain(String name, int gold) {
        super(name, gold);
        alcoholResilience = 2;
    }

    //METHODS--------------------------------
    public void grabDrink(Pirate pirate) {
        if (pirate.drinksHave.size() > 0) {
            this.drinksHave.add(pirate.drinksHave.get(pirate.drinksHave.size() - 1));
            pirate.drinksHave.remove(drinksHave.size() - 1);
        }
    }

}