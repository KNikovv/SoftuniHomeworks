package wasteDisposal.models.wastes;

import wasteDisposal.annotations.Recyclable;

@Recyclable
public class RecyclableWaste extends AbstractWaste {

    public RecyclableWaste(String name,double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
