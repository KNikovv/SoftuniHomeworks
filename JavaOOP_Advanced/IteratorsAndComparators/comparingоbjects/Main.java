package comparingоbjects;

import comparingоbjects.interfaces.Person;
import comparingоbjects.models.PersonImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> personList = new ArrayList<>();

        while (true) {
            String line = buffReader.readLine();

            String[] params = line.split("\\s+");

            if (params[0].equalsIgnoreCase("end")) {
                break;
            }

            String name = params[0];
            Integer age = Integer.valueOf(params[1]);
            String town = params[2];

            Person currentPerson = new PersonImpl(name, age, town);

            personList.add(currentPerson);

        }

        int nthPersonInList = Integer.parseInt(buffReader.readLine());

        int numberOfNotEqualPeople = findNotEqualPeopleCount(personList, nthPersonInList);

        int numberOfEqualPeople = personList.size() - numberOfNotEqualPeople;

        int totalPeopleCount = personList.size();

        printCounts(numberOfNotEqualPeople, numberOfEqualPeople, totalPeopleCount);
    }

    private static void printCounts(int numberOfNotEqualPeople, int numberOfEqualPeople, int totalPeopleCount) {

        if (numberOfEqualPeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d\n", numberOfEqualPeople,
                                            numberOfNotEqualPeople,
                                            totalPeopleCount);
        }

    }

    private static int findNotEqualPeopleCount(List<Person> personList, int nthPersonInList) {

        int notEqualCount = 0;

        Person personToLookFor = personList.get(nthPersonInList - 1);

        for (Person currentPerson : personList) {
            notEqualCount += personToLookFor.compareTo(currentPerson);
        }

        return notEqualCount;
    }
}
