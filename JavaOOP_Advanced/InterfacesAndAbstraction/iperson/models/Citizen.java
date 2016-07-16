package iperson.models;

import iperson.interfaces.Birthable;
import iperson.interfaces.IPerson;
import iperson.interfaces.Identifiable;

public class Citizen implements IPerson, Birthable, Identifiable {

    private String name;
    private int age;
    private String id;
    private String birthdate;

    public Citizen(String name, int age, String id, String birthdate) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthday() {
        return this.birthdate;
    }

    @Override
    public String getID() {
        return this.id;
    }
}
