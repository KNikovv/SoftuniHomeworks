package wasteDisposal.commands;

import wasteDisposal.annotations.Inject;
import wasteDisposal.commands.contracts.Executable;
import wasteDisposal.data.RecyclingStation;

public abstract class CommandAbstract implements Executable {

    @Inject
    private RecyclingStation recyclingStation;

    public CommandAbstract() {

    }

    protected RecyclingStation getRecyclingStation() {
        return this.recyclingStation;
    }
}
