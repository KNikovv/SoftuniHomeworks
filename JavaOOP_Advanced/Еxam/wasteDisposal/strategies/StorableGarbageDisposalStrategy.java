package wasteDisposal.strategies;

import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;
import wasteDisposal.models.processingdata.StorableProcessingData;
import wasteDisposal.utilities.Constants;

public class StorableGarbageDisposalStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double totalVolume = garbage.getWeight() * garbage.getVolumePerKg();
        double energyBalance = totalVolume * Constants.STORABLE_ENERGY_MODIFIER;
        double capitalBalance = Constants.STORABLE_CAPITAL_MODIFIER * totalVolume;
        ProcessingData processingData = new StorableProcessingData(energyBalance,capitalBalance);

        return processingData;
    }
}
