package com.company;

import java.util.List;
import java.util.Random;

public enum CarType {
    FORD, BMW, MERCEDES, OPEL, SUZUKI;

    public static final List<CarType> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static CarType randomCarType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
