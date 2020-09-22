package ImplementCharSequence;

public class CharSequenceMain {
    public static void main(String[] args) {
        Gnirts g = new Gnirts("example");
        System.out.println(g.charAt(1));
        System.out.println(g.length());
        System.out.println(g.subSequence(0, 2));

        System.out.println();

        Shifter s = new Shifter("exampleTwo", 2);
        System.out.println(s.charAt(0));
        System.out.println(s.length());
        System.out.println(s.subSequence(0, 2));

    }
}
