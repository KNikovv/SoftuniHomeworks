package wasteDisposal.models.processingdata;

public class StorableProcessingData extends AbstractProcessingData {


    public StorableProcessingData(double energyBalance, double capitalBalance) {
        super(energyBalance, capitalBalance);
    }

    @Override
    protected void setEnergyBalance(double energyAmount) {
        this.energyBalance = this.energyBalance - energyAmount;
    }

    @Override
    protected void setCapitalBalance(double capitalAmount) {
        this.capitalBalance = this.capitalBalance - capitalAmount;
    }
}
