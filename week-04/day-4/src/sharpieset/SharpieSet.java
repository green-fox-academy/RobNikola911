package sharpieset;

import java.awt.*;
import java.util.ArrayList;

public class SharpieSet {
    private ArrayList<String> sharpielist = new ArrayList<>();

    public SharpieSet() {

    }

    public SharpieSet(ArrayList<String> sharpielist) {
        this.sharpielist = sharpielist;
    }

    public void countUsable() {
        for (String sharpie : sharpielist) {

        }
    }
}

/*
Create SharpieSet class it contains a list of Sharpie
                countUsable() -> sharpie is usable if it has ink in it
        removeTrash() -> removes all unusable sharpies*/
