package greenfoxorganization;

import java.util.List;

public class Cohort {
    private String name;
    private List students;
    private List mentors;

    public Cohort(String name, List students, List mentors) {
        this.name = name;
        this.students = students;
        this.mentors = mentors;
    }


    public void addStudent(Student student) {

    }

    public void addMentor(Mentor mentor) {

    }

    public void info() {
        System.out.println("The " + name + " cohort has " +
                students.size() + " students and " + mentors.size() + " mentors.");
    }
}
