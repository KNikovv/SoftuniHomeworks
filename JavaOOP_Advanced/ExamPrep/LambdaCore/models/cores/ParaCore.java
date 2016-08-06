package bg.softuni.models.models.cores;

import bg.softuni.models.constants.Values;

public class ParaCore extends BaseCore {

    public ParaCore(int durability) {
        super(durability);
    }

    @Override
    protected void setDurability(int durability) {
        super.setDurability(durability / Values.PARACORE_DIVIDER);
    }
}
