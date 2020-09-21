package sharpieset;

import java.awt.*;
import java.util.ArrayList;

public class SharpieSet {
    private ArrayList<Sharpie> sharpieList = new ArrayList<>();

    public SharpieSet() {

    }

    public SharpieSet(ArrayList<Sharpie> sharpieList) {
        this.sharpieList = sharpieList;
    }

    public int countUsable() {
        int usableSharpie = 0;
        for (Sharpie sharpie : sharpieList) {
            if (sharpie.getInkAmount() != 0) {
                usableSharpie++;
            }
        }
        return usableSharpie;
    }

    public void removeTrash() {
        for (Sharpie sharpie : sharpieList) {
            if (sharpie.getInkAmount() == 0) {
                sharpieList.remove(sharpie);
            }
        }
    }
}

/*
Create SharpieSet class it contains a list of Sharpie
                countUsable() -> sharpie is usable if it has ink in it
        removeTrash() -> removes all unusable sharpies*/
