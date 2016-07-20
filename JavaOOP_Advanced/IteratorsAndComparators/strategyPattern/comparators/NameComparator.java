package strategyPattern.comparators;

import strategyPattern.interfaces.Person;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {

        int nameLengthCompare = Integer.compare(firstPerson.getName().length(),
                                                    secondPerson.getName().length());

        int firstLetterCompare = Character.compare(firstPerson.getName().toLowerCase().charAt(0),
                                                    secondPerson.getName().toLowerCase().charAt(0));

        if (nameLengthCompare == 0) {
            return firstLetterCompare;
        } else {
            return nameLengthCompare;
        }
    }
}
