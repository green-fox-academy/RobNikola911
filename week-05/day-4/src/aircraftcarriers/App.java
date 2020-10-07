package aircraftcarriers;

import java.util.Collections;

public class App {
    public static void main(String[] args) {
        AbstractAC ac1 = new F16();
        AbstractAC ac2 = new F35();
        AbstractAC ac3 = new F16();
        AbstractAC ac4 = new F35();
        AbstractAC ac5 = new F16();

    System.out.println(ac1.getStatus());
    System.out.println(ac1.refill(500));
    System.out.println(ac1.getStatus());
        System.out.println(ac1.fight());


        Carrier c1 = new Carrier(1000,1000);


        System.out.println(c1.getStatus());

        Collections.addAll(c1.listOfPlanes, ac3, ac2, ac4);
        c1.fillAllACs();
        System.out.println(c1.getStatus());

    }
}