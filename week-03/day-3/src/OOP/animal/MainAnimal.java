package OOP.animal;

public class MainAnimal {
    public static void main(String[] args) {
        AnimalC tiger = new AnimalC();
        tiger.eat();
        tiger.drink();
        tiger.play();
        tiger.play();
        tiger.play();

        System.out.println(tiger.status());


        AnimalC bear = new AnimalC(33, 24);
        bear.eat();
        bear.eat();
        System.out.println(bear.status());

    }
}
