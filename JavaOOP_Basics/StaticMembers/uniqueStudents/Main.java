package uniqueStudents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line ;
        StudentGroup studentGroup = new StudentGroup();
        while(!(line=bf.readLine()).equals("End")){
            Student student = new Student(line);
            studentGroup.addStudent(student);
        }
        System.out.println(StudentGroup.uniqueCounter);
    }

}
