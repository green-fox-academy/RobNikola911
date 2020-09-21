import gardenapplications.TheGarden;
import gardenapplications.ThePlants;

public class GardenApplicationMain {
    public static void main(String[] args) {
        TheGarden garden = new TheGarden();
        ThePlants flower1 = new ThePlants("yellow", "Flower", 0);
        ThePlants flower2 = new ThePlants("blue", "Flower",0);
        ThePlants tree1 = new ThePlants("purple", "Tree",0);
        ThePlants tree2 = new ThePlants("blue", "Tree", 0);

        garden.addPlant(flower1);
        garden.addPlant(flower2);
        garden.addPlant(tree1);
        garden.addPlant(tree2);

        garden.getGardenState();
        garden.watering(40);
        garden.getGardenState();
        garden.watering(70);
        garden.getGardenState();
    }
}

