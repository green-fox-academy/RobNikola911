package com.greenfox.backendapi.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum YodaThing {
    ARRGH("Arrgh."),
    UHMM("Uhmm."),
    ERR("Err..err.err."),
    HMMM("Hmmm.");

    public final String label;

    private YodaThing(String label) {
        this.label = label;
    }

    private static final List<YodaThing> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static YodaThing randomThing()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}