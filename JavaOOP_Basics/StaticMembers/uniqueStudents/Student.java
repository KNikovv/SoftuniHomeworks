package uniqueStudents;

public class Student {

    String name;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private Student setName(String name) {
        this.name = name;
        return this;
    }
}
