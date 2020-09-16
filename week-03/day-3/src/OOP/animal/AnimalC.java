package OOP.animal;

public class AnimalC {
    private int hunger;
    private int thirst;

    public AnimalC(int hunger, int thirst) {
        this.hunger = hunger;
        this.thirst = thirst;
    }

    public AnimalC() {
        hunger = 50;
        thirst = 50;
    }


    public void eat() {
        hunger--;
    }

    public void drink() {
        thirst--;
    }


    public void play() {
        thirst++;
        hunger++;
    }

    public String status() {
        return "Hunger level: " + hunger + "\nThirst level: " + thirst;
    }
}



