package teacherstudents;

public class Teacher {

    private String name;

    public Teacher(){

    }

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void teach(Student student) {
        student.learn();
    }
    public void answer(){
        System.out.println(getName() + " is answering a question.");
    }
}
/*
    Teacher
    teach(student) -> calls the students learn method
        answer() -> prints the teacher is answering a question*/
