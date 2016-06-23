package familyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line = bf.readLine();
        String personName = !line.contains("/") ? line : "";
        String personBirthday = line.contains("/") ? line : "";

        Person personWanted = new Person(personName, personBirthday);

        List<Person> fullDataPeople = new ArrayList<>();
        List<Person> halfDataPeople = new ArrayList<>();

        while (!(line = bf.readLine()).equals("End")) {
            String[] input = line.split(" - ");
            switch (input.length) {
                case 1:
                    String[] newSplit = line.split("\\s+");
                    String name = newSplit[0] + " " + newSplit[1];
                    String birthday = newSplit[2];
                    fullDataPeople.add(new Person(name, birthday));
                    break;
                case 2:
                    String nameOrBirthdayParent = input[0];
                    String nameOrBirthdayChild = input[1];
                    Person parent = nameOrBirthdayParent.contains("/") ? new Person("", nameOrBirthdayParent) :
                            new Person(nameOrBirthdayParent, "");
                    Person child = nameOrBirthdayChild.contains("/") ? new Person("", nameOrBirthdayChild) :
                            new Person(nameOrBirthdayChild, "");
                    parent.addChild(child);
                    child.addParent(parent);
                    halfDataPeople.add(parent);
                    halfDataPeople.add(child);
                    break;
            }
        }
        halfDataPeople.stream().forEach(partialPerson -> {
            fullDataPeople.stream().filter(fullPerson -> fullPerson.getBirthday().equals(partialPerson.getBirthday()) ||
                    fullPerson.getName().equals(partialPerson.getName())).forEach(fullPerson -> {
                partialPerson.getParents().stream().forEach(parent-> {
                    fullPerson.addParent(parent);
                });
                partialPerson.getChildren().stream().forEach(child->{
                    fullPerson.addChild(child);
                });
                partialPerson.changeName(fullPerson.getName());
                partialPerson.changeBirthday(fullPerson.getBirthday());
            });
        });
        fullDataPeople.stream().forEach(person -> {
            if (person.getName().equals(personWanted.getName()) ||
                    person.getBirthday().equals(personWanted.getBirthday())) {
                System.out.println(person);
            }
        });
    }
}
 class Person {
    String name;
    String birthday;
    List<Person> parents;
    List<Person> children;

    Person(String name, String birthday) {
        this.setName(name);
        this.setBirthday(birthday);
        this.setParents(new ArrayList<>());
        this.setChildren(new ArrayList<>());
    }

    public void changeName(String name) {
        this.setName(name);
    }

    public void changeBirthday(String birthday) {
        this.setBirthday(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public void addChild(Person child) {
        this.getChildren().add(child);
    }

    public void addParent(Person parent) {
        this.getParents().add(parent);
    }

    @Override
    public String toString() {
        StringBuilder personBuilder = new StringBuilder();
        personBuilder.append(this.getName()).append(" ").append(this.getBirthday()).append(System.lineSeparator());
        personBuilder.append("Parents:\n");
        this.getParents().stream().forEach(parent ->
                personBuilder.append(parent.getName()).append(" ")
                        .append(parent.getBirthday()).append(System.lineSeparator()));
        personBuilder.append("Children:\n");
        this.getChildren().stream().forEach(child ->
                personBuilder.append(child.getName()).append(" ").append(child.getBirthday()).append(System.lineSeparator()));
        String personOutput = personBuilder.toString();
        return personOutput;
    }
}