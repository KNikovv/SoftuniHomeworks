package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.core.annotations.Inject;

public class RetireCommand extends Command {

    @Inject
    private Repository repository;
    protected RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];

        return this.repository.removeUnit(unitType);
    }
}
