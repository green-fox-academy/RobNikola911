package greenfoxorganization;

public class Student extends Person {
    private String previousOrganization;
    private int skippedDays;

    public Student() {
        this.name = "Jane Doe";
        this.age = 30;
        this.gender = "female";
        this.previousOrganization = "The School of Life";
        this.skippedDays = 0;
    }

    public Student(String previousOrganization) {
        this.previousOrganization = previousOrganization;
    }

    public Student(String name, int age, String gender, String previousOrganization) {
        super(name, age, gender);
        this.previousOrganization = previousOrganization;
        this.skippedDays = 0;
        int numberOfDays = 0;

    }

    @Override
    public void getGoal() {
        System.out.println("Be a junior software developer.");
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I,m " + name + ", a " + age + " year old "
                + gender + " from " + previousOrganization + " who skipped "
                + skippedDays + " days from the course already.\"");
    }

    public void skipDays(int numberOfDays) {
        skippedDays += numberOfDays;
    }
}
