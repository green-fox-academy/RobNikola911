package Zoo;

public class Reptile extends Animal {
//    public Reptile(String name, int age, String gender) {
//        super(name, age, gender);
//    }

    public Reptile(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "laying eggs.";
    }
}
