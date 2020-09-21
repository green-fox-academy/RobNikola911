package farms;

public class Animal {
    private int hunger;
    private int thirst;

    public Animal(int hunger, int thirst) {
        this.hunger = hunger;
        this.thirst = thirst;
    }

    public Animal() {
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

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }
}
