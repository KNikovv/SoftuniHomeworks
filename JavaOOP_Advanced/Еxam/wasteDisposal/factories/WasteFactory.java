package wasteDisposal.factories;

import wasteDisposal.contracts.Waste;

public interface WasteFactory {

    Waste createWaste(String name, double volumePerKg, double weight, String type) throws ReflectiveOperationException;
}
