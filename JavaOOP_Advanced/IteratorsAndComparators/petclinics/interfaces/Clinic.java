package petclinics.interfaces;

public interface Clinic {

    void addPet(Pet pet);

    void releasePet();

    Pet[] getRooms();

    String getSpecificRoomInfo(int roomIndex);

    String getAllRoomsInfo();

    boolean hasEmptyRooms();

    boolean hasReleased();

}
