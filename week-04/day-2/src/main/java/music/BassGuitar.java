package main.java.music;

public class BassGuitar extends StringedInstrument {
    public BassGuitar(String instrumentName, int numberOfStrings) {
        super(instrumentName, numberOfStrings);
    }

    public BassGuitar() {
        this.numberOfStrings = 4;
    }

    public BassGuitar(int strings) {
        this.numberOfStrings = strings;
    }

    @Override
    public void sound() {
        System.out.println("Bass Guitar, a " + this.numberOfStrings + "-stringed instrument that goes Duum-duum-duum");
    }
}
