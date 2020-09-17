package sharpieset;

import java.util.ArrayList;

public class SharpieMain {
    public static void main(String[] args) {
        Sharpie coloredPens = new Sharpie();
        coloredPens.setColor("RED");
        coloredPens.setWidth(2.5f);

        for (int i = 0; i < 23; i++) {
            coloredPens.use();
        }
        System.out.println(coloredPens.getInkAmount());

        ArrayList<Sharpie> sharpieList = new ArrayList<>();
        for (int j = 0; j < 30; j++) {
            sharpieList.add(new Sharpie());
        }
        SharpieSet sharpieSet = new SharpieSet(sharpieList);

        System.out.println(sharpieSet.countUsable());
        sharpieSet.removeTrash();
    }
}