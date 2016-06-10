import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<StudentSpecialty> specialties = new ArrayList<>();
        String line;
        //Adding specialties
        while (!(line = bf.readLine()).equals("Students:")) {
            String[] data = line.split("\\s+");
            String specialty = data[0] + " " + data[1];
            String facultyNumber = data[2];
            StudentSpecialty currentSpecialty = new StudentSpecialty(specialty, facultyNumber);
            specialties.add(currentSpecialty);
        }
        //Adding students
        List<Developer> studentList = new ArrayList<>();
        while (!(line = bf.readLine()).equals("END")) {
            String[] data = line.split("\\s+");
            String facultyNumber = data[0];
            String fullName = data[1] + " " + data[2];
            Developer currentStudent = new Developer(fullName, facultyNumber);
            studentList.add(currentStudent);
        }
        BiPredicate<StudentSpecialty, Developer> predicate = (studentSpecialty, student) ->
                studentSpecialty.getFacultyNumber().equals(student.getFacultyNumber());

        studentList.stream().sorted((dev1, dev2) -> dev1.getName().compareTo(dev2.getName()))
                .forEach(dev -> {
                    specialties.stream().filter((spec) -> predicate.test(spec, dev))
                            .forEach(devleft -> {
                                System.out.printf("%s %s %s\n", dev.getName(),
                                        dev.getFacultyNumber(), devleft.getSpecialtyName());
                            });
                });
    }


}

class Developer {
    private String name;
    private String facultyNumber;

    Developer(String firstName, String facultyNumber) {
        this.setName(firstName);
        this.setFacultyNumber(facultyNumber);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }


    public String getFacultyNumber() {
        return facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}

class StudentSpecialty {
    private String specialtyName;
    private String facultyNumber;

    public StudentSpecialty(String specialtyName, String facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    private void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}