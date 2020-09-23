package Zoo;

public abstract class Animal {
    protected String name;
    protected int age;
    protected String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Animal(String name){
        this.name = name;
        age = 1;
        gender = "male";
    }

    public String getName(){
        return name;
    }

    public String breed(){
        return "Breeding...";
    }

    public void sound(String sound) {
        System.out.println(sound);
    }

}
