package wasteDisposal.models.wastes;

import wasteDisposal.annotations.Storable;

@Storable
public class StorableWaste extends AbstractWaste {

    public StorableWaste(String name,double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
