package sharpies;

public class SharpieMain {
    public static void main(String[] args) {
        Sharpie coloredPens = new Sharpie();
        coloredPens.setColor("white");
        coloredPens.setWidth(2.5f);

        for (int i = 0; i < 23; i++) {
            coloredPens.use();
        }

        System.out.println(coloredPens.getInkAmount());
    }
}
