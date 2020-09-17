package farms;

public class AnimalMain {
    public static void main(String[] args) {
        Animal chicken = new Animal();
        chicken.eat();
        chicken.drink();
        chicken.play();
        chicken.play();
        chicken.play();

        System.out.println("chicken " + chicken.status());


        Animal cow = new Animal(33, 24);
        cow.eat();
        cow.eat();
        System.out.println("cow " + cow.status());

        Animal pig = new Animal(23, 42);
        for (int i = 0; i < 14; i++) {
            pig.play();
        }
        pig.eat();
        System.out.println("pig " + pig.status());

        Farm newFarm = new Farm(10);
        for (int i = 0; i < 100; i++) {
            newFarm.breed();
        }
        newFarm.slaughter();
    }
}