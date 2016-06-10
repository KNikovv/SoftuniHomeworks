import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String,ArrayList<Integer>> students = new LinkedHashMap<>();
        String line ;
        while(!(line= bf.readLine()).equals("END")){
            String [] studentData = line.split("\\s+");
            String fullName = studentData[0] + " " + studentData[1];
            ArrayList<Integer> grades = new ArrayList<>();
            for(int i = 2;i<studentData.length;i++){
                int grade = Integer.parseInt(studentData[i]);
                grades.add(grade);
            }
            students.put(fullName,grades);
        }
        students.entrySet().stream()
                .filter(g -> g.getValue().contains(6))
                .forEach(s-> System.out.println(s.getKey()));
    }
}
