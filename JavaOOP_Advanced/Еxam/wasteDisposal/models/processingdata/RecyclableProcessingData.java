package wasteDisposal.models.processingdata;

public class RecyclableProcessingData extends AbstractProcessingData {

    public RecyclableProcessingData(double energyBalance, double capitalBalance) {
        super(energyBalance, capitalBalance);
    }

    @Override
    protected void setEnergyBalance(double energyAmount) {
        this.energyBalance = this.energyBalance - energyAmount;
    }
}
