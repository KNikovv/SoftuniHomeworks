package sample.home;

import sample.models.Adult;
import sample.models.Child;

import java.util.List;

public class YoungCoupleWithChildren extends YoungCouple {

    private static final int ROOM_CONSUMPTION = 30;
    private static final int ROOM_COUNT = 2;

    public YoungCoupleWithChildren(Adult male, Adult female, double tvConsumption, double fridgeConsumption, double
            laptopConsumption, List<Child> childList) {
        super(male, female, tvConsumption, fridgeConsumption, laptopConsumption);
        this.roomsConsumption = ROOM_COUNT * ROOM_CONSUMPTION;
        this.children = childList;
    }
}
