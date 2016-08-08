package wasteDisposal.commands;

import wasteDisposal.utilities.Messages;

public class ChangeManagementRequirementCommand extends CommandAbstract {

    @Override
    public String execute(String... args) throws ReflectiveOperationException {
        double energyBound = Double.valueOf(args[0]);
        double capitalBound = Double.valueOf(args[1]);
        String garbageType = args[2];

        this.getRecyclingStation().setRequirements(energyBound, capitalBound, garbageType);
        return String.format(Messages.MANAGEMENT_REQUIREMENT_CHANGED);
    }
}
