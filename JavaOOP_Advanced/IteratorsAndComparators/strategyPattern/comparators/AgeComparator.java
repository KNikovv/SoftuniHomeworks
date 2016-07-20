package strategyPattern.comparators;

import strategyPattern.interfaces.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getAge().compareTo(secondPerson.getAge());
    }
}
