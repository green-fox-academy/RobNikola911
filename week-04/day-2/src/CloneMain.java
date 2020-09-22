import clones.Person;
import clones.Student;

import java.util.ArrayList;

public class CloneMain {

    public static void main(String[] args) {

        ArrayList<Student> cloneList = new ArrayList<>();
        Student john = new Student("John", 20, "male", "BME");
        cloneList.add(john);
        System.out.println(cloneList.size());
        Student johnTheClone = john.clone();
        cloneList.add(johnTheClone);
        System.out.println(cloneList.size());
        System.out.println(johnTheClone.name + " " + johnTheClone.age + " "
                + johnTheClone.gender + " " + johnTheClone.previousOrganization + ".");
    }
}