package kingsgambit.models;

import kingsgambit.interfaces.king.King;

public class Footman extends UnitImpl {

    private static final int DEFAULT_HEALTH = 2;

    public Footman(String name, King king) {
        super(name, king);
        this.setHealthPoints(DEFAULT_HEALTH);
    }

    @Override
    public void handleRespondToAttack() {
        System.out.printf("Footman %s is panicking!\n", this.getName());
    }

}
