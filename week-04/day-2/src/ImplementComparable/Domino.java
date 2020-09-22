package ImplementComparable;

public class Domino implements Comparable<Domino> {
    private final int left;
    private final int right;

    public Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }

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

    @Override
    public int compareTo(Domino obj) {
        if (obj.left < this.left) {
            return 1;
        } else if (obj.left == this.left) {
            if (obj.right < this.right) {
                return 1;
            } else if (obj.right == this.right) {
                return 0;
            } else return -1;
        } else
            return -1;
    }
}