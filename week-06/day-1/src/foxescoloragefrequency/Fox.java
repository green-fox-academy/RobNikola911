package foxescoloragefrequency;


public class Fox {
    protected String name;
    protected String color;
    protected int age;

    public Fox(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return this.name;
    }
}
