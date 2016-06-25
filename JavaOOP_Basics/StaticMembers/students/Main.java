package students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line ;
        while(!(line=bf.readLine()).equals("End")){
            Student student = new Student(line);
        }
        System.out.println(Student.studentCount);
    }
}

class Student {

    static int studentCount;
    String name;

    Student(String name) {
        this.name = name;
        studentCount++;
    }
}