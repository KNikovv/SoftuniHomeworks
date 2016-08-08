package wasteDisposal.commands;

import wasteDisposal.annotations.Inject;
import wasteDisposal.contracts.GarbageProcessor;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;
import wasteDisposal.factories.WasteFactory;
import wasteDisposal.utilities.Messages;

public class ProcessGarbageCommand extends CommandAbstract {

    @Inject
    private WasteFactory wasteFactory;
    @Inject
    private GarbageProcessor garbageProcessor;

    public ProcessGarbageCommand() {
        super();
    }

    @Override
    public String execute(String... args) throws ReflectiveOperationException {
        String commandResult;
        String name = args[0];
        double weight = Double.valueOf(args[1]);
        double volumeInKg = Double.valueOf(args[2]);
        String wasteType = args[3];
        Waste waste = this.wasteFactory.createWaste(name, weight, volumeInKg, wasteType);
        ProcessingData processingData = this.garbageProcessor.processWaste(waste);
        double wasteEnergyBalance = processingData.getEnergyBalance();
        double wasteCapitalBalance = processingData.getCapitalBalance();
        if (this.getRecyclingStation().canDisposeWasteType(wasteEnergyBalance, wasteCapitalBalance, wasteType)) {
            this.getRecyclingStation().addProcessingData(processingData);
            commandResult = String.format(Messages.SUCCESSFULLY_PROCESSED_TYPE, weight, name);
            return commandResult;
        }
        commandResult = Messages.FAILED_TO_PROCESS_TYPE;
        return commandResult;
    }
}
