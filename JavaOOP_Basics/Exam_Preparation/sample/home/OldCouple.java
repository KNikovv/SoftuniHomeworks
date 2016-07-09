package sample.home;

import sample.models.Adult;

public class OldCouple extends Home {

    private static final int ROOM_CONSUMPTION = 15 ;
    private static final int ROOM_COUNT = 3 ;

    public OldCouple(Adult male , Adult female, double tvConsumption, double fridgeConsumption, double stoveConsumption) {
        super();
        this.adults.add(male);
        this.adults.add(female);
        this.tvConsumption = tvConsumption;
        this.fridgeConsumption = fridgeConsumption;
        this.stoveConsumption = stoveConsumption;
        this.roomsConsumption = ROOM_COUNT * ROOM_CONSUMPTION;
    }
}
