import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Predicate;

public class StudentsEnrolledIn14or15 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line;
        LinkedHashMap<String,List<Integer>> studentsFacultyNumbers = new LinkedHashMap<>();
        while(!(line=bf.readLine()).equals("END")){
            String[] data = line.split("\\s+");
            String facultyNumber = data[0];
            List<Integer> grades = new ArrayList<>();
            for(int i = 1;i<data.length;i++){
                int grade = Integer.parseInt(data[i]);
                grades.add(grade);
            }
            studentsFacultyNumbers.put(facultyNumber,grades);
        }
        Predicate<String> studentsFrom14or15 = (y)-> y.endsWith("14")||y.endsWith("15");
        studentsFacultyNumbers.entrySet().stream()
                .filter(fNum-> studentsFrom14or15.test(fNum.getKey()))
                .forEach(marks -> {
                    marks.getValue().forEach(g-> System.out.printf("%d ",g));
                    System.out.println();
                });
    }
}
