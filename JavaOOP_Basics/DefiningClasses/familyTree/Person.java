package familyTree;

import google.Child;

import java.util.ArrayList;
import java.util.List;

//public class Person {
//    String name;
//    String birthday;
//    List<Person> parents;
//    List<Person> children;
//
//    Person(String name, String birthday) {
//        this.setName(name);
//        this.setBirthday(birthday);
//        this.setParents(new ArrayList<>());
//        this.setChildren(new ArrayList<>());
//    }
//
//    public void changeName(String name) {
//        this.setName(name);
//    }
//
//    public void changeBirthday(String birthday) {
//        this.setBirthday(birthday);
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(String birthday) {
//        this.birthday = birthday;
//    }
//
//    public List<Person> getParents() {
//        return parents;
//    }
//
//    public void setParents(List<Person> parents) {
//        this.parents = parents;
//    }
//
//    public List<Person> getChildren() {
//        return children;
//    }
//
//    public void setChildren(List<Person> children) {
//        this.children = children;
//    }
//
//    public void addChild(Person child) {
//        this.getChildren().add(child);
//    }
//
//    public void addParent(Person parent) {
//        this.getParents().add(parent);
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder personBuilder = new StringBuilder();
//        personBuilder.append(this.getName()).append(" ").append(this.getBirthday()).append(System.lineSeparator());
//        personBuilder.append("Parents:\n");
//        this.getParents().stream().forEach(parent ->
//                                        personBuilder.append(parent.getName()).append(" ")
//                                                .append(parent.getBirthday()).append(System.lineSeparator()));
//        personBuilder.append("Children:\n");
//        this.getChildren().stream().forEach(child ->
//                personBuilder.append(child.getName()).append(" ").append(child.getBirthday()).append(System.lineSeparator()));
//        String personOutput = personBuilder.toString();
//        return personOutput;
//    }
//}
