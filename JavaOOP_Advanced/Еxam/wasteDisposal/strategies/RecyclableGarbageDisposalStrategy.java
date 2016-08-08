package wasteDisposal.strategies;

import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;
import wasteDisposal.models.processingdata.RecyclableProcessingData;
import wasteDisposal.utilities.Constants;

public class RecyclableGarbageDisposalStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double totalVolume = garbage.getWeight() * garbage.getVolumePerKg();
        double energyBalance = totalVolume * Constants.RECYCLABLE_ENERGY_MODIFIER;
        double capitalBalance = Constants.RECYCLABLE_CAPITAL_MODIFIER * garbage.getWeight();
        ProcessingData processingData = new RecyclableProcessingData(energyBalance,capitalBalance);

        return processingData;
    }
}
