package petclinics.interfaces;

import java.util.Map;

public interface ClinicDatabase {

    Map<String,Clinic> getAllClinics();

    Map<String,Pet> getAllPets();

    void addClinic(String clinicName, Integer roomCapacity);

    void addPet(String name, Integer age, String kind);

    void addPetToClinic(String petName, String clinicName);

    boolean isAdded();


}
