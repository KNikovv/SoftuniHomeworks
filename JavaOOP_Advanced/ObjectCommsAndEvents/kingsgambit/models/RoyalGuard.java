package kingsgambit.models;

import kingsgambit.interfaces.king.King;

public class RoyalGuard extends UnitImpl {

    private static final int DEFAULT_HEALTH = 3;

    public RoyalGuard(String name, King king) {
        super(name,king);
        this.setHealthPoints(DEFAULT_HEALTH);
    }

    @Override
    public void handleRespondToAttack() {
        System.out.printf("Royal Guard %s is defending!\n", this.getName());
    }

}
