import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        ArrayList<String> studentData = new ArrayList<>();
        while (!(line = bufferedReader.readLine()).equals("END")) {
            String[] inputData = line.split("\\s+");
            String fullStudentData = inputData[0] + " " + inputData[1] + " " + inputData[2];
            studentData.add(fullStudentData);
        }
        Predicate<Integer> agePredicate = age -> age >= 18 && age <= 24;
        studentData.stream()
                .filter(studentInfo -> {
            int age = Integer.parseInt(studentInfo.substring(studentInfo.lastIndexOf(" ")+1));
            return agePredicate.test(age);
        })
                .forEach(System.out::println);
    }
}
