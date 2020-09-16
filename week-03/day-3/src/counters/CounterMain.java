package counters;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CounterMain {

    Counter c = new Counter();

    @Test
    public void addMore() {
        c.add(5);
        assertEquals(5, c.get());
    }

    @Test
    public void addOne() {
        c.add();
        assertEquals(1, c.get());
    }

    @Test
    public void getZero() {
        assertEquals(0, c.get());
    }

    @Test
    public void getInit() {
        Counter c = new Counter(7);
        assertEquals(7, c.get());
    }

    @Test
    public void resetToZero() {
        c.add();
        c.reset();
        assertEquals(0, c.get());
    }

    @Test
    public void resetToInit() {
        Counter c = new Counter(7);
        c.add(5);
        c.reset();
        assertEquals(7, c.get());
    }
}

