package main.java.music;

public abstract class StringedInstrument extends Instrument {
    int numberOfStrings;

    public StringedInstrument(String instrumentName, int numberOfStrings) {
        super(instrumentName);
        this.numberOfStrings = numberOfStrings;
    }

    public StringedInstrument() {
        super();
    }


    public abstract void sound();

    @Override
    public void play() {
        this.sound();
    }
}
