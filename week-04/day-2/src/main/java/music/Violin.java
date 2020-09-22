package main.java.music;

public class Violin extends StringedInstrument {

    public Violin(String instrumentName, int numberOfStrings) {
        super(instrumentName, numberOfStrings);
    }

    public Violin() {
        this.numberOfStrings = 4;
    }

    @Override
    public void sound() {
        System.out.println("Violin, a " + this.numberOfStrings + "-stringed instrument that goes Screech");
    }
}
