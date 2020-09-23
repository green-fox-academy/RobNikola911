package Zoo;

public class Mammal extends Animal {
//    public Mammal(String name, int age, String gender) {
//        super(name, age, gender);
//    }

    public Mammal(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "pushing miniature versions out.";
    }

    public boolean hasMilk(String gender) {
        return gender.equals("female");
    }
}
