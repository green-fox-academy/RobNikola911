package ImplementCharSequence;

public class Shifter implements CharSequence {
    protected String shiftStr;
    protected int shift;

    public Shifter(String shiftStr, int shift) {
        this.shift = shift;
        this.shiftStr = shiftStr;
    }

    public Shifter() {
    }

    @Override
    public int length() {
        return this.shiftStr.length();
    }

    @Override
    public char charAt(int index) {
        return this.shiftStr.charAt(this.shift + index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.shiftStr.subSequence(start + this.shift, end + this.shift);
    }
}
