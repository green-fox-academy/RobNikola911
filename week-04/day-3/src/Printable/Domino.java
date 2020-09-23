package Printable;

public class Domino implements Printable {
    protected int left;
    protected int right;

    public Domino(int right, int left) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void printAllFields() {
        System.out.println("Domino A side: " + this.left + ", B side: " + this.right);
    }
}
