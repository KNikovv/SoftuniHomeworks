package animalClinic;

public class Animal {

    String name;
    String breed;

    Animal(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return String.format("Patient %d: [%s (%s)] has been", AnimalClinic.patientID, this.name, this.breed);
    }
}
