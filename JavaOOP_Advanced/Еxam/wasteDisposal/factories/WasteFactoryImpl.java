package wasteDisposal.factories;

import wasteDisposal.contracts.Waste;

public class WasteFactoryImpl implements WasteFactory {

    private static final String WASTE_PATH = "wasteDisposal.models.wastes.";
    private static final String WASTE_SUFFIX = "Waste";

    @Override
    @SuppressWarnings("unchecked")
    public Waste createWaste(String name, double volumePerKg, double weight, String type) throws
            ReflectiveOperationException {
        Waste waste;
        Class<Waste> wasteClass = (Class<Waste>) Class.forName(WASTE_PATH + type + WASTE_SUFFIX);
        waste = wasteClass
                .getDeclaredConstructor(String.class, double.class, double.class)
                .newInstance(name, volumePerKg, weight);
        return waste;
    }
}
