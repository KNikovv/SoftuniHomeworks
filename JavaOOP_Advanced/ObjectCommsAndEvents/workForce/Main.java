package workForce;

import workForce.interfaces.Employee;
import workForce.interfaces.Job;
import workForce.models.JobImpl;
import workForce.models.PartTimeEmployee;
import workForce.models.StandartEmployee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        List<Job> allJobs = new LinkedList<>();
        Map<String, Employee> employeesByName = new HashMap<>();

        while (true) {
            String[] params = buffReader.readLine().split("\\s+");
            switch (params[0].toLowerCase()) {
                case "standartemployee": {
                    createStandartEmployee(employeesByName, params[1]);
                }
                break;
                case "parttimeemployee": {
                    createPartTimeEmployee(employeesByName, params[1]);
                }
                break;
                case "job": {
                    Job job = createJob(employeesByName, params);
                    allJobs.add(job);
                }
                break;
                case "pass": {
                    updateJobs(allJobs);

                    allJobs.removeIf(Job::isDone);
                }
                break;
                case "status": {
                    allJobs.forEach(System.out::println);
                }
                break;
                case "end":
                    return;
            }
        }
    }

    private static void updateJobs(List<Job> allJobs) {
        for (Job job : allJobs) {
            job.update();
        }
    }

    private static Job createJob(Map<String, Employee> employeesByName, String[] params) {
        String nameOfJob = params[1];
        int hoursRequired = Integer.valueOf(params[2]);
        String employeeName = params[3];
        Employee employeeToWork = employeesByName.get(employeeName);
        return new JobImpl(nameOfJob, employeeToWork, hoursRequired);
    }

    private static void createPartTimeEmployee(Map<String, Employee> employeesByName, String param) {
        String name = param;
        Employee employee = new PartTimeEmployee(name);
        employeesByName.put(name, employee);
    }

    private static void createStandartEmployee(Map<String, Employee> employeesByName, String param) {
        String name = param;
        Employee employee = new StandartEmployee(name);
        employeesByName.put(name, employee);
    }
}
