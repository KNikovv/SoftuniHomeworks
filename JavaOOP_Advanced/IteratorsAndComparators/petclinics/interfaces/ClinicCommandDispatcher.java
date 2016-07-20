package petclinics.interfaces;

public interface ClinicCommandDispatcher extends CommandDispatcher {

    void createPet(String name, Integer age, String kind);

    void createClinic(String name, Integer roomCapacity);

    void addPetToClinic(String petName, String clinicName);

    void release(String clinicName);

    void hasEmptyRooms(String clinicName);

    void getInfoForEachRoom(String clinicName);

    void getInfoForParticularRoom(String clinicName, Integer roomNumber);
}
