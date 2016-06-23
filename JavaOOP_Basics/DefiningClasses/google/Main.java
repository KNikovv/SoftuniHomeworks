package google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Person> personHashMap = new HashMap<>();
        String line;
        while (!(line = bf.readLine()).equals("End")) {
            String[] input = line.split("\\s+");
            String personName = input[0];
            Person person;
            if (!personHashMap.containsKey(personName)) {
                person = new Person(personName);
                personHashMap.put(personName, person);
            } else {
                person = personHashMap.get(personName);
            }
            String parameter = input[1];
            switch (parameter) {
                case "company":
                    String companyName = input[2];
                    String companyDep = input[3];
                    double salary = Double.parseDouble(input[4]);
                    Company company = new Company(companyName, companyDep, salary);
                    person.changeCompany(company);
                    break;
                case "car":
                    String carModel = input[2];
                    int carSpeed = Integer.parseInt(input[3]);
                    Car car = new Car(carModel,carSpeed);
                    person.changeCar(car);
                    break;
                case "pokemon":
                    String pokemonName = input[2];
                    String pokemonType = input[3];
                    Pokemon pokemon = new Pokemon(pokemonName,pokemonType);
                    person.addPokemon(pokemon);
                    break;
                case "parents":
                    String parentName = input[2];
                    String parentBirthday = input[3];
                    Parent parent = new Parent(parentName,parentBirthday);
                    person.addParent(parent);
                    break;
                case "children":
                    String childName = input[2];
                    String childBirthday = input[3];
                    Child child = new Child(childName,childBirthday);
                    person.addChild(child);
                    break;
            }
        }
        String personRequired = bf.readLine();
        for (Map.Entry<String, Person> stringPersonEntry : personHashMap.entrySet()) {
            String personName = stringPersonEntry.getKey();
            Person currentPerson = stringPersonEntry.getValue();
            if(personName.equals(personRequired)){
                System.out.println(currentPerson.toString());
            }
        }
    }
}
