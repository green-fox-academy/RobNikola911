package clones;

public class Student extends Person implements Cloneable {
    public String previousOrganization;
    protected int skippedDays;

    public Student() {
        super();
        this.previousOrganization = "The School of Life";
        this.skippedDays = 0;
    }

    public Student(String name, int age, String gender, String previousOrganization) {
        super(name, age, gender);
        this.previousOrganization = previousOrganization;
        skippedDays = 0;
    }


    @Override
    public void getGoal() {
        System.out.println("Be a junior software developer.");
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + " from " + previousOrganization +
                " who skipped " + skippedDays + " days from the course already.\"");
    }

    public void skipDays(int numberOfDays) {
        skippedDays += numberOfDays;
    }


    @Override
    public Student clone() {
        Student s = new Student(this.name, this.age, this.gender, this.previousOrganization);
        return s;
    }
}