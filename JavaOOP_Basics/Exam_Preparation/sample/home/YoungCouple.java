package sample.home;

import sample.models.Adult;

public class YoungCouple extends Home {

    private final int ROOM_COUNT = 2;
    private final int ROOM_CONSUMPTION = 20;

    public YoungCouple(Adult male,
                       Adult female,
                       double tvConsumption,
                       double fridgeConsumption,
                       double laptopConsumption) {
        super();
        this.adults.add(male);
        this.adults.add(female);
        this.tvConsumption = tvConsumption;
        this.fridgeConsumption = fridgeConsumption;
        this.laptopConsumption = laptopConsumption + laptopConsumption;
        this.roomsConsumption = ROOM_CONSUMPTION*ROOM_COUNT;
    }
}
