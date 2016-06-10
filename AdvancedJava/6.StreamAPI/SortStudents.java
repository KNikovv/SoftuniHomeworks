import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Student> studentList = new ArrayList<>();
        String line;

        while (!(line = bf.readLine()).equals("END")) {
            String[] separatedFullName = line.split("\\s+");
            String firstName = separatedFullName[0];
            String lastName = separatedFullName[1];
            Student student = new Student(firstName, lastName);
            studentList.add(student);
        }
        Comparator<Student> byLastName = (s1, s2) -> s1.getLastName().compareTo(s2.getLastName());
        Comparator<Student> byFirstName = (s1, s2) -> s2.getFirstName().compareTo(s1.getFirstName());
        studentList.stream()
                .sorted(byFirstName)
                .sorted(byLastName)
                .forEach(s1 -> System.out.printf("%s %s\n", s1.getFirstName(), s1.getLastName()));
    }
}

