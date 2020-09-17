package petrolstation;

public class PetrolStationMain {
    public static void main(String[] args) {

        Car newCar = new Car();
        newCar.setGasAmount(0);

        Station petrol = new Station();
        petrol.setGasAmount(300);
        petrol.refill(newCar);

        System.out.println(newCar.getGasAmount());
        System.out.println(petrol.getGasAmount());
    }
}
