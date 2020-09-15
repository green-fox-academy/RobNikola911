package com.company;

import java.util.List;
import java.util.Random;

public enum CarColor {
    GREEN, RED, BLUE, YELLOW;

    public static final List<CarColor> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static CarColor randomCarColor()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
