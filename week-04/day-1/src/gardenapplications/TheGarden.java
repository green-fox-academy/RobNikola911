package gardenapplications;

import java.util.ArrayList;
import java.util.List;

public class TheGarden {
    protected List<ThePlants> garden;

    public TheGarden() {
        garden = new ArrayList<>();
    }

    public void addPlant(ThePlants plant) {
        garden.add(plant);
    }

    public void watering(int water) {
        System.out.println("Watering with " + water);
        int howManyNeedWater = 0;
        for (ThePlants plant : garden) {
            if (plant.needWater())
                howManyNeedWater++;
        }
        for (ThePlants plant : garden) {
            if (plant.needWater())
                plant.watering(water / howManyNeedWater);
        }
    }

    public void getGardenState() {
        for (ThePlants plant : garden) {
            if (plant.needWater()) {
                System.out.println("The " + plant.getColor() + " " + plant.getType() + " needs water");
            } else {
                System.out.println("The " + plant.getColor() + " " + plant.getType() +
                        " doesn't need water");
            }
        }
    }
}