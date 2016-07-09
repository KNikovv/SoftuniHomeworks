package sample.home;

import sample.models.Adult;

public class OldAlone extends Home {

    private static final int ROOM_CONSUMPTION = 15 ;
    private static final int ROOM_COUNT = 1 ;

    public OldAlone(Adult adult) {
        super();
        this.adults.add(adult);
        this.roomsConsumption = ROOM_COUNT * ROOM_CONSUMPTION;
    }
}
