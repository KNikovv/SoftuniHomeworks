package animalClinic;

import java.util.ArrayList;
import java.util.List;

public class AnimalClinic {

    static int patientID;
    static int healedAnimalsCounter;
    static int rehabilitedAnimalsCounter;
    static List<Animal> healedAnimals;
    static List<Animal> rehabilitatedAnimals;

    AnimalClinic() {
        healedAnimals = new ArrayList<>();
        rehabilitatedAnimals = new ArrayList<>();
    }
    public  void healAnimal(Animal pesho) {
        patientID++;
        healedAnimalsCounter++;
        healedAnimals.add(pesho);
        System.out.println(pesho.toString() + " healed!");
    }

    public  void rehabilitateAnimal(Animal pesho) {
        patientID++;
        rehabilitedAnimalsCounter++;
        rehabilitatedAnimals.add(pesho);
        System.out.println(pesho.toString() + " rehabilitated!");
    }

    public  List<Animal> returnAnimals(String type) {
        return type.equals("heal") ? healedAnimals : rehabilitatedAnimals;
    }

}
