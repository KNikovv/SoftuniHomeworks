package mankind.main;

import mankind.models.Student;
import mankind.models.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));



        try {
            String[] studentInfo = buffReader.readLine().split("\\s+");
            String studentFirstName = studentInfo[0];
            String studentLastName = studentInfo[1];
            String studentFacNumber = studentInfo[2];
            Student student = new Student(studentFirstName, studentLastName, studentFacNumber);
            String[] workerInfo = buffReader.readLine().split("\\s+");
            String workerFirstName = workerInfo[0];
            String workerLastName = workerInfo[1];
            double workerSalary = Double.valueOf(workerInfo[2]);
            double workerHoursPerDay = Double.valueOf(workerInfo[3]);
            Worker worker = new Worker(workerFirstName, workerLastName, workerSalary, workerHoursPerDay);
            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
