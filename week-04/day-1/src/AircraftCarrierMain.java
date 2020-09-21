import aircraftcarriers.Aircraft;
import aircraftcarriers.Carrier;

public class AircraftCarrierMain {
    public static void main(String[] args) throws Exception {
        Carrier carrier = new Carrier(58, 5);
        Aircraft aircraft1 = new Aircraft("F35");
        Aircraft aircraft2 = new Aircraft("F35");
        Aircraft aircraft3 = new Aircraft("F35");
        Aircraft aircraft4 = new Aircraft("F16");
        Aircraft aircraft5 = new Aircraft("F16");

        carrier.add(aircraft1);
        carrier.add(aircraft2);
        carrier.add(aircraft3);
        carrier.add(aircraft4);
        carrier.add(aircraft5);

        carrier.fill();
        aircraft1.fight();
        aircraft2.fight();
        aircraft3.fight();
        aircraft4.fight();
        aircraft5.fight();
        carrier.fill();

        carrier.getStatus();

    }
}
