package fleetofthings;

public class FleetOfThingsMain {

    public static void main(String[] args) {
        Fleet fleet = new Fleet();
        fleet.add(new Thing("Get milk", false));
        fleet.add(new Thing("Remove the obstacles", false));
        fleet.add(new Thing("Stand up", true));
        fleet.add(new Thing("Eat lunch", true));
        Thing something = new Thing("Eat lunch", false);
        something.complete();
        fleet.add(something);

        // - In the main method create a fleet
        // - Achieve this output:
        // Create a fleet of things to have this output:
        // 1. [ ] Get milk
        // 2. [ ] Remove the obstacles
        // 3. [x] Stand up
        // 4. [x] Eat lunch

        System.out.println(fleet);
    }
}