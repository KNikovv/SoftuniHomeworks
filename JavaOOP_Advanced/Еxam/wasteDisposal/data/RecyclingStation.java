package wasteDisposal.data;

import wasteDisposal.contracts.ProcessingData;

public interface RecyclingStation {

    String getStatus();

    void addProcessingData(ProcessingData processingData);

    boolean canDisposeWasteType(double energy, double capital, String type);

    void setRequirements(double energyBound, double capitalBound, String typeBanned);
}
