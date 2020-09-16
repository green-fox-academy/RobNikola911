package dominok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Domino {
    private final int left;
    private final int right;

    public Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }
    public boolean getOrder() {
        if (getRightSide() == getLeftSide()){
            return true;
        }return false;
    }
//    public List<Domino> getAll() {
//        return new ArrayList<Domino>(dominoes);
//    }

    public int getLeftSide() {
        return left;
    }

    public int getRightSide() {
        return right;
    }

    @Override
    public String toString() {
        return "[" + left + ", " + right + "]";
    }
}