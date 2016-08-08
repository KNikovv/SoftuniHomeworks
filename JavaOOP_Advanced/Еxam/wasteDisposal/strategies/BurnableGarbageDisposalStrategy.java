package wasteDisposal.strategies;

import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;
import wasteDisposal.models.processingdata.BurnableProcessingData;
import wasteDisposal.utilities.Constants;

public class BurnableGarbageDisposalStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double totalVolume = garbage.getWeight() * garbage.getVolumePerKg();
        double energyBalance = totalVolume * Constants.BURNABLE_ENERGY_MODIFIER;
        double capitalBalance = Constants.BURNABLE_CAPITAL_MODIFIER;
        ProcessingData processingData = new BurnableProcessingData(energyBalance,capitalBalance);

        return processingData;
    }
}
