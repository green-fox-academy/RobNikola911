package piratesinn;

import java.util.ArrayList;
import java.util.List;

public class PirateInn {

    protected List<Pirate> pirates;
    protected int capacity;

    //CONSTRUCTORS--------------------------
    public PirateInn() {
        this.capacity = 20;
        pirates = new ArrayList<>();
    }

    public PirateInn(int capacity) {
        this.capacity = capacity;
        pirates = new ArrayList<>();
    }


    //METHODS--------------------------------
    public void joinParty(Pirate pirate) {
        if (capacity == pirates.size()) {
            System.out.println("There is no more space in the Inn!");
        } else if (pirate instanceof Captain && this.hasCaptain()) {
            System.out.println("There is already a captain in the inn!");
        } else {
            pirates.add(pirate);
        }
    }

    public boolean hasCaptain() {
        for (Pirate pirate : pirates) {
            if (pirate instanceof Captain) {
                return true;
            }
        }
        return false;
    }

    public void sellDrink(Pirate pirate) {
        if (pirate.gold < 2) {
            System.out.println("Get off, " + pirate.name + "!");
        } else if (pirate.gold < 20) {
            pirate.drinksHave.add(Drinks.BEER);
            pirate.gold -= 2;
        } else {
            pirate.drinksHave.add(Drinks.RUM);
            pirate.gold -= 5;
        }
    }

    public void getSummary() {
        int numberOfBeer = 0;
        int numberOfRum = 0;
        for (Pirate pirate : pirates) {
            for (Drinks drink : pirate.drinksHad) {
                if (drink == Drinks.BEER) {
                    numberOfBeer++;
                } else {
                    numberOfRum++;
                }
            }
        }
        System.out.println("{rum: " + numberOfRum + "}{beer : " + numberOfBeer+ "}");
    }

    public void getCostOfDrinksHad() {
        int totalCost = 0;
        for (Pirate pirate : pirates) {
            for (Drinks drink : pirate.drinksHad) {
                if (drink == Drinks.BEER) {
                    totalCost += 2;
                } else {
                    totalCost += 5;
                }
            }
        }
        System.out.println("All the pirates drunk for " + totalCost + " gold.");
    }

    public void getCostOfDrinksHad(Pirate pirate) {
        int totalCost = 0;
        for (Drinks drink : pirate.drinksHad) {
            if (drink == Drinks.BEER) {
                totalCost += 2;
            } else {
                totalCost += 5;
            }
        }
        System.out.println(pirate.name + " drunk for " + totalCost + " gold.");
    }

    public void oneMoreRound() {
        for (Pirate pirate : pirates) {
            sellDrink(pirate);
        }
    }

    public void party() {
        for (Pirate pirate : pirates) {
            while (pirate.gold >= 2) {
                sellDrink(pirate);
                pirate.drink();
            }
        }
    }
}