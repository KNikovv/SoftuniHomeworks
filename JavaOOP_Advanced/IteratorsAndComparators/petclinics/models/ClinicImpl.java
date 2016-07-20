package petclinics.models;

import petclinics.interfaces.Clinic;
import petclinics.interfaces.Pet;

public class ClinicImpl implements Clinic {

    private String clinicName;
    private Pet[] rooms;
    private int roomsCapacity;
    private int occupiedRoomsCount;
    private int roomIndex;
    private int releaseIndex;
    private int leftIndex;
    private int rightIndex;
    private boolean canAddToLeftRoom;
    private boolean hasReleased;


    public ClinicImpl(String clinicName, int roomsCapacity) {
        this.setClinicName(clinicName);
        this.setRoomsCapacity(roomsCapacity);
        this.setOccupiedRoomsCount(0);
        this.setRoomIndex(roomsCapacity / 2);
        this.setLeftRoomIndex(this.roomIndex);
        this.setRightRoomIndex(this.roomIndex);
        this.setReleaseIndex(this.roomIndex);
        this.setCanAddToLeftRoom(true);
        this.rooms = new Pet[roomsCapacity];
    }


    private void setLeftRoomIndex(int leftIndex) {
        this.leftIndex = leftIndex;
    }

    private void setRightRoomIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }

    private void setReleaseIndex(int releaseIndex) {
        this.releaseIndex = releaseIndex;
    }

    private void setCanAddToLeftRoom(boolean canAddToLeftRoom) {
        this.canAddToLeftRoom = canAddToLeftRoom;
    }

    private void setRoomIndex(int index) {
        this.roomIndex = index;
    }

    private void setClinicName(String name) {
        this.clinicName = name;
    }

    private void setRoomsCapacity(int roomsCapacity) {
        if (roomsCapacity % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.roomsCapacity = roomsCapacity;
    }

    private void setOccupiedRoomsCount(int occupiedRoomsCount) {
        this.occupiedRoomsCount = occupiedRoomsCount;
    }

    @Override
    public void addPet(Pet pet) {
        if (this.rooms[roomIndex] == null) {
            this.rooms[roomIndex] = pet;
            this.occupiedRoomsCount++;
            changeIndex();
        }
    }


    @Override
    public boolean hasReleased() {
        return this.hasReleased;
    }

    @Override
    public void releasePet() {
        if (this.occupiedRoomsCount == 0) {
            this.hasReleased = false;
            return;
        }
        int currentIndex = this.releaseIndex;
        while (true) {
            if (this.rooms[currentIndex] != null) {
                this.rooms[currentIndex] = null;
                this.hasReleased = true;
                this.occupiedRoomsCount--;
                break;
            }
            currentIndex = (currentIndex + 1) % this.rooms.length;
            if (currentIndex % this.releaseIndex == 0) {
                break;
            }
        }
    }

    @Override
    public Pet[] getRooms() {
        return this.rooms;
    }

    @Override
    public String getSpecificRoomInfo(int roomIndex) {
        String roomState;
        if(this.getRooms()[roomIndex-1]==null){
            roomState = "Room empty";
        }else{
            roomState = this.getRooms()[roomIndex-1].toString();
        }

        return roomState;
    }

    @Override
    public String getAllRoomsInfo() {
        StringBuilder builder = new StringBuilder();
        for (Pet pet : this.getRooms()) {
            if (pet != null) {
                builder.append(pet).append(System.lineSeparator());
                continue;
            }
            builder.append("Room empty").append(System.lineSeparator());
        }
        return builder.toString();
    }

    @Override
    public boolean hasEmptyRooms() {
        return this.occupiedRoomsCount < this.roomsCapacity;
    }

    private void changeIndex() {
        if (this.canAddToLeftRoom) {
            this.canAddToLeftRoom = false;
            this.leftIndex--;
            this.roomIndex = this.leftIndex;
            return;
        }
        this.canAddToLeftRoom = true;
        this.rightIndex++;
        this.roomIndex = rightIndex;
    }

}
