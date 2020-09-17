package farms;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private List<Animal> listOfAnimals;

    private int freeSpaces;

    public Farm() {
        this.listOfAnimals = new ArrayList<>();
    }

    public Farm(List<Animal> listOfAnimals) {
        this.listOfAnimals = listOfAnimals;
    }

    public Farm(int freeSpaces) {
        this.freeSpaces = freeSpaces;
        this.listOfAnimals = new ArrayList<>();
    }

    public void breed() {
        if (freeSpaces > 0) {
            listOfAnimals.add(new Animal());
            freeSpaces--;
        }
    }

    public void slaughter() {
        Animal leastHungry = listOfAnimals.get(0);
        for (Animal animal : listOfAnimals) {
            if (animal.getHunger() < leastHungry.getHunger()) {
                leastHungry = animal;
            }
        }
        listOfAnimals.remove(leastHungry);
        freeSpaces++;
    }
}

/*
    farms has list of Animals
        it has slots which defines the number of free places for animals
        breed() -> creates a new animal if there's place for it
        slaughter() -> removes the least hungry animal*/
