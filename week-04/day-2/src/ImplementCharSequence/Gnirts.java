package ImplementCharSequence;

public class Gnirts implements CharSequence {

    protected String example;

    public Gnirts(String example) {
        this.example = example;
    }

    public Gnirts() {

    }

    @Override
    public int length() {
        return this.example.length();
    }

    @Override
    public char charAt(int index) {
        return this.example.charAt(example.length() - index - 1);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.example.subSequence(example.length() - end, example.length() - start);
    }
}
