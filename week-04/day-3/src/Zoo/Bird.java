package Zoo;

public class Bird extends Animal{
//    public Bird(String name, int age, String gender) {
//        super(name, age, gender);
//    }

    public Bird(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "laying eggs.";
    }
}
