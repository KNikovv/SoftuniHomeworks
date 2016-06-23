package opinionPoll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OpinionPoll {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(bf.readLine());
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String[] nameAndAge = bf.readLine().split("\\s");
            String name = nameAndAge[0];
            int age = Integer.parseInt(nameAndAge[1]);
            Person person = new Person(age, name);
            personList.add(person);
        }
        personList.stream()
                .sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
                .filter(person -> person.getAge() > 30)
                .forEach(System.out::println);

    }
}

class Person {
    private String name;
    private int age;

    Person(int age, String name) {
        this.setAge(age);
        this.setName(name);
    }

    Person(int age) {
        this(age, "No name");
    }

    Person() {
        this(0, "No name");
    }

    int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.getName(), this.getAge());
    }
}