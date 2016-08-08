package wasteDisposal.models.processingdata;

import wasteDisposal.contracts.ProcessingData;

public class AbstractProcessingData implements ProcessingData {

    protected double energyBalance;
    protected double capitalBalance;

    protected AbstractProcessingData(double energyBalance, double capitalBalance) {
        this.setEnergyBalance(energyBalance);
        this.setCapitalBalance(capitalBalance);
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }


    protected void setEnergyBalance(double energyAmount) {
        this.energyBalance = energyAmount;
    }

    protected void setCapitalBalance(double capitalAmount) {
        this.capitalBalance = capitalAmount;
    }
}
