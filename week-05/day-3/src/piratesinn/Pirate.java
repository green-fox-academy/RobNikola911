package piratesinn;

import java.util.ArrayList;
import java.util.List;

enum Drinks {
    BEER, RUM
}
public class Pirate {
    protected String name;
    protected int hp;
    protected int gold;
    protected int alcoholLevel;
    protected List<Drinks> drinksHave;
    protected List<Drinks> drinksHad;
    protected int alcoholResilience;


//CONSTRUCTORS--------------------------

    public Pirate(String name) {
        this.name = name;
        hp = 50;
        gold = (int) (Math.random() * 21) + 10;
        alcoholLevel = 0;
        drinksHave = new ArrayList<>();
        drinksHad = new ArrayList<>();
        alcoholResilience = 1;
    }

    public Pirate(String name, int gold) {
        this.name = name;
        this.gold = gold;
        hp = 50;
        alcoholLevel = 0;
        drinksHave = new ArrayList<>();
        drinksHad = new ArrayList<>();
        alcoholResilience = 1;
    }

    //GETTERS--------------------------------

    public List<Drinks> getDrinksHave() {
        return drinksHave;
    }

    //METHODS--------------------------------

    public void drink() {
        Drinks nextDrinkInRow;
        if (this.drinksHave.size() == 0) {
            System.out.println("Shoot, I have no booze left!");
        } else {
            nextDrinkInRow = this.drinksHave.get(drinksHave.size() - 1);
            if (this.drinksHad.size() == 0) {
                System.out.println("Gimee that booze!");
            }
            if (this.alcoholLevel < 15) {
                System.out.println("Cheers, and he drinks his " + nextDrinkInRow.toString().toLowerCase());
            } else {
                System.out.println("Yaaaaaarrrr");
            }
            if (nextDrinkInRow == Drinks.BEER) {
                this.alcoholLevel += 2 / alcoholResilience;
            } else {
                this.alcoholLevel += 6 / alcoholResilience;
            }
            this.drinksHad.add(nextDrinkInRow);
            this.drinksHave.remove(drinksHave.size() - 1);
        }
    }


    @Override
    public String toString() {
        return "Im " + name + ", I had " + drinksHave.size() + "drinks.";
    }

    //    ToString method should return text in this format "Im Esy, I had x drinks.""
}
