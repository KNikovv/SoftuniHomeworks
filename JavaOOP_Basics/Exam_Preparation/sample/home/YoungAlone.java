package sample.home;

import sample.models.Adult;

public class YoungAlone extends OldAlone {

    private static final int ROOM_CONSUMPTION = 10;
    private static final int ROOM_COUNT = 1;

    public YoungAlone(Adult adult, double laptopConsumption) {
        super(adult);
        this.laptopConsumption = laptopConsumption;
        this.roomsConsumption = ROOM_COUNT * ROOM_CONSUMPTION;
    }
}
