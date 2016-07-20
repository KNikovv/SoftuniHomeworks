package strategyPattern;

import strategyPattern.comparators.AgeComparator;
import strategyPattern.comparators.NameComparator;
import strategyPattern.interfaces.Person;
import strategyPattern.models.PersonImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> nameTreeSet = new TreeSet<>(new NameComparator());
        TreeSet<Person> ageTreeSet = new TreeSet<>(new AgeComparator());

        int countOfLines = Integer.valueOf(buffReader.readLine());

        for (int currentLineIndex = 0; currentLineIndex < countOfLines; currentLineIndex++) {
            String[] params = buffReader.readLine().split("\\s+");

            String name = params[0];
            Integer age = Integer.valueOf(params[1]);

            nameTreeSet.add(new PersonImpl(name, age));
            ageTreeSet.add(new PersonImpl(name, age));
        }

        nameTreeSet.forEach(System.out::println);
        ageTreeSet.forEach(System.out::println);
    }
}
