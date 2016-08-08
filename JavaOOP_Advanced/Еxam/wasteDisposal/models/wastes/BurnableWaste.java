package wasteDisposal.models.wastes;

import wasteDisposal.annotations.Burnable;

@Burnable
public class BurnableWaste extends AbstractWaste {

    public BurnableWaste(String name,double weight, double volumePerKg) {
        super(name,weight, volumePerKg );
    }
}
