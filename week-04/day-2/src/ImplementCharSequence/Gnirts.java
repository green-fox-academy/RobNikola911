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
        String reverse = "";
        for (int i = this.example.length() - 1; i >= 0; i--) {
            reverse += this.example.charAt(i);
        }
        return reverse.subSequence(start, end);
//        return this.example.subSequence(example.length() - end, example.length() - start);
    }
}
