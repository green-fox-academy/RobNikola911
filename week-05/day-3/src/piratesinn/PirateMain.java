package piratesinn;

public class PirateMain {
    public static void main(String[] args) {

        PirateInn inn = new PirateInn(10);
        Pirate john = new Pirate("John", 25);
        Pirate john1 = new Pirate("John1", 10);
        Pirate john2 = new Pirate("John2", 5);
        Pirate john7 = new Pirate("John2", 5);
        Pirate john8 = new Pirate("John2", 5);
        Pirate john9 = new Pirate("John2", 5);
        Pirate john10 = new Pirate("John2", 5);
        Pirate john3 = new Pirate("John3", 25);
        Pirate john4 = new Pirate("John4", 25);
        Pirate john5 = new Pirate("John5", 25);
        Pirate john6 = new Pirate("John6", 25);
        Pirate jack = new Captain("Jack");
        Pirate jones = new Captain("Jones", 40);
        inn.joinParty(john);
        inn.joinParty(jack);
        inn.joinParty(jones);
        System.out.println(inn.hasCaptain());
        inn.party();
        inn.getSummary();
        inn.getCostOfDrinksHad(john);
        inn.sellDrink(john);

    }
}