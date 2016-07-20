package strategyPattern.models;

import strategyPattern.interfaces.*;

public class PersonImpl implements Person {

    private String personName;
    private Integer personAge;

    public PersonImpl(String personName, Integer personAge) {
        this.setPersonName(personName);
        this.setPersonAge(personAge);
    }

    @Override
    public String getName() {
        return this.personName;
    }

    @Override
    public Integer getAge() {
        return this.personAge;
    }

    private void setPersonName(String personName) {
        this.personName = personName;
    }

    private void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getAge();
    }
}
