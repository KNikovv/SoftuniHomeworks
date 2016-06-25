package animalClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static animalClinic.AnimalClinic.healedAnimalsCounter;
import static animalClinic.AnimalClinic.rehabilitedAnimalsCounter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line;
        AnimalClinic clinic = new AnimalClinic();
        while (!(line = bf.readLine()).equals("End")) {
            String input[] = line.split("\\s+");
            String name = input[0];
            String breed = input[1];
            String operation =input[2];
            Animal pesho = new Animal(name,breed);
            if(operation.equals("heal")){
                clinic.healAnimal(pesho);
            }else{
                clinic.rehabilitateAnimal(pesho);
            }
        }
        System.out.printf("Total healed animals: %d\nTotal rehabilitated animals: %d\n",
                               healedAnimalsCounter,rehabilitedAnimalsCounter);
        String returnType = bf.readLine();
        List<Animal> returnees = clinic.returnAnimals(returnType);
        for(Animal animal : returnees){
            System.out.println(animal.getName() + " " + animal.getBreed());
        }
    }
}
