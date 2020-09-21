package teacherstudents;

public class TeacherStudentMain {
    public static void main(String[] args) {
        Student student1 = new Student("Peter");
        student1.learn();
        Student student2 = new Student("Robert");

        Teacher teacher1 = new Teacher("Istvan");
        teacher1.teach(student2);
        student2.question(teacher1);
        teacher1.answer();

    }

}
