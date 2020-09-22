package main.java.music;

public class ElectricGuitar extends StringedInstrument {

    public ElectricGuitar(String instrumentName, int numberOfStrings) {
        super(instrumentName, numberOfStrings);
    }

    public ElectricGuitar() {
        this.numberOfStrings = 6;
    }

    public ElectricGuitar(int strings) {
        this.numberOfStrings = strings;
    }

    @Override
    public void sound() {
        System.out.println("Electric Guitar, a " + this.numberOfStrings + "-stringed instrument that goes Twang");
    }
}
