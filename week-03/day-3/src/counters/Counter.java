package counters;

public class Counter {
    private int counter;
    private int initial;

    public Counter(int counter) {
        this.counter = counter;
        this.initial = counter;
    }

    public Counter() {
        counter = 0;
        initial = counter;
    }

    public void add(int number) {
        this.counter += number;
    }

    public int add() {
        return counter++;
    }

    public int get() {
        return counter;
    }

    public void reset() {
        counter = initial;
    }
//    public int resetToInt(){
//        if (add() != 0)
//        return add()=0;
//    }

}
