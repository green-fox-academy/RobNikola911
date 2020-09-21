package greenfoxorganization;

public class Sponsor extends Person {
    private String company;
    private int hiredStudents;

    public Sponsor() {
        this.name = "Jane Doe";
        this.age = 30;
        this.gender = "female";
        this.company = "Google";
        this.hiredStudents = 0;
    }

    public Sponsor(String name, int age, String gender, String company) {
        super(name, age, gender);
        this.company = company;
        hiredStudents = 0;
    }

    public void hire() {
        hiredStudents++;
    }

    @Override
    public void getGoal() {
        System.out.println("Hire brilliant junior software developers.");
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old "
                + gender + " who represents " + company + " and hired "
                + hiredStudents + " students so far.");
    }


}
