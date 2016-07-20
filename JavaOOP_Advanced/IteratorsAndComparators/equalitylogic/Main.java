package equalitylogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        Integer lineCount = Integer.valueOf(buffReader.readLine());

        TreeSet<Person> personTreeSet = new TreeSet<>(new PersonComparator());
        HashSet<Person> personHashSet = new HashSet<>();

        for (int currentLine = 0; currentLine < lineCount; currentLine++) {

            String[] params = buffReader.readLine().split("\\s+");

            String name = params[0];
            Integer age = Integer.valueOf(params[1]);

            Person person = new Person(name, age);

            personTreeSet.add(person);

            personHashSet.add(person);

        }

        System.out.println(personHashSet.size());

        System.out.println(personTreeSet.size());

    }
}
