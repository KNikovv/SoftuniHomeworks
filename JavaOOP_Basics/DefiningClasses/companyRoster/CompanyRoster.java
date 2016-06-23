package companyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CompanyRoster {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, List<Double>> departments = new HashMap<>();
        int n = Integer.parseInt(bf.readLine());
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split("\\s+");
            String currentName = input[0];
             double currentSalary = Double.parseDouble(input[1]);
            String currentPosition = input[2];
            String currentDepartment = input[3];
            String currentEmail = null;
            Integer currentAge = null;
            switch (input.length) {
                case 5:
                    currentEmail = input[4].contains("@") ? input[4] : null;
                    currentAge = !input[4].contains("@") ? Integer.parseInt(input[4]) : null;
                    break;
                case 6:
                    currentEmail = input[4];
                    currentAge = Integer.parseInt(input[5]);
                    break;
            }
            Employee employee = new Employee(currentName, currentSalary, currentPosition, currentDepartment, currentEmail, currentAge);
            if (!departments.containsKey(currentDepartment)) {
                departments.put(currentDepartment, new ArrayList<>());
            }
            departments.get(currentDepartment).add(currentSalary);
            employeeList.add(employee);
        }
        HashMap<String, Double> averages = new HashMap<>();
        departments.entrySet().stream().forEach(e -> {
            double a = e.getValue().stream().mapToDouble(i -> i).average().getAsDouble();
            averages.put(e.getKey(), a);
        });
        String departmentWithHighestSalary =
                Collections.max(averages.entrySet(), (entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).getKey();

        System.out.printf("Highest Average Salary: %s\n",departmentWithHighestSalary);

        employeeList.stream()
                .filter(e -> e.getDepartment().equals(departmentWithHighestSalary))
                .sorted((e1,e2)-> Double.compare(e2.getSalary(),e1.getSalary()))
                .forEach(System.out::println);
    }
}

class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private Integer age;

    Employee(String name, double salary, String position, String department, String email, Integer age) {
        this.setName(name);
        this.setSalary(salary);
        this.setPosition(position);
        this.setDepartment(department);
        this.setAge(age);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    private void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    private void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        if (email == null) {
            this.email = "n/a";
            return;
        }
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    private void setAge(Integer age) {
        if (age == null) {
            this.age = -1;
            return;
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }
}
