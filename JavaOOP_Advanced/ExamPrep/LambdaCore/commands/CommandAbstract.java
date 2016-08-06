package bg.softuni.models.commands;

import bg.softuni.models.annotations.Inject;
import bg.softuni.models.data.interfaces.PowerPlant;

public abstract class CommandAbstract implements Executable {

    @Inject
    private PowerPlant powerPlant;

    protected CommandAbstract() {

    }

    @Override
    public abstract String execute(String... args) throws ReflectiveOperationException;

    protected PowerPlant getPowerPlant() {
        return this.powerPlant;
    }
}
