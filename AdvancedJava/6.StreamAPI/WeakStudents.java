import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, List<Integer>> students = new LinkedHashMap<>();
        String line;
        while (!(line = bf.readLine()).equals("END")) {
            String[] studentData = line.split("\\s+");
            String fullName = studentData[0] + " " + studentData[1];
            List<Integer> grades = new ArrayList<>();
            for (int i = 2; i < studentData.length; i++) {
                int grade = Integer.parseInt(studentData[i]);
                grades.add(grade);
            }
            students.put(fullName, grades);
        }
        students.entrySet().stream()
                .filter(e-> {
                    List<Integer> weakGradesForStudent = new ArrayList<Integer>();
                    weakGradesForStudent = e.getValue().stream().filter(k -> k<=3).collect(Collectors.toList());
                    return weakGradesForStudent.size()>=2;
                })
                .forEach(s -> System.out.println(s.getKey()));
    }
}
