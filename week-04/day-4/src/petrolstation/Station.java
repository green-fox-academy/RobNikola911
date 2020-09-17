package petrolstation;

public class Station {
    private int gasAmount;

    public Station() {

    }

    public Station(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    public int getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    public void refill(Car car) {
        setGasAmount(getGasAmount() - (car.getCapacity() - car.getGasAmount()));
        car.setGasAmount(car.getGasAmount() + car.getCapacity() - car.getGasAmount());
    }
}
  /*  Station
            gasAmount
    refill(car) -> decreases the gasAmount by the capacity of the car and increases the cars gasAmount
*/