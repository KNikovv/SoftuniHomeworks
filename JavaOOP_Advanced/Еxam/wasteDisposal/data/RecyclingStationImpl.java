package wasteDisposal.data;

import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.utilities.Messages;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedList;

public class RecyclingStationImpl implements RecyclingStation {

    private Collection<ProcessingData> data;
    private double energyBound;
    private double capitalBound;
    private String garbageTypeBanned;

    public RecyclingStationImpl() {
        this.data = new LinkedList<>();
        this.setEnergyBound(Double.MAX_VALUE);
        this.setCapitalBound(Double.MAX_VALUE);
        this.setGarbageTypeBanned(Messages.NO_BAN_YET);
    }

    @Override
    public String getStatus() {
        return String.format(Messages.STATUS_REPORT_MESSAGE,
                this.getTotalEnergy(),
                this.getTotalCapital());
    }

    @Override
    public void addProcessingData(ProcessingData processingData) {
        this.data.add(processingData);
    }

    @Override
    public boolean canDisposeWasteType(double energy, double capital, String type) {
        BigDecimal energyValue = this.getTotalEnergy().add(BigDecimal.valueOf(energy));
        BigDecimal capitalValue = this.getTotalCapital().add(BigDecimal.valueOf(capital));

        if (type.equals(this.getGarbageTypeBanned())) {
            return (checkEnergyIsLower(energyValue, this.getEnergyBound()) &&
                    checkCapitalIsLower(capitalValue, this.getCapitalBound()));
        }
        return true;
    }

    private boolean checkEnergyIsLower(BigDecimal energyValue, double energyBound) {
        if (energyValue.compareTo(BigDecimal.valueOf(energyBound)) < 0) {
            return true;
        }
        return false;
    }

    private boolean checkCapitalIsLower(BigDecimal capitalValue, double capitalBound) {
        if (capitalValue.compareTo(BigDecimal.valueOf(capitalBound)) < 0) {
            return true;
        }
        return false;
    }

    @Override
    public void setRequirements(double energyBound, double capitalBound, String typeBanned) {
        this.setEnergyBound(energyBound);
        this.setCapitalBound(capitalBound);
        this.setGarbageTypeBanned(typeBanned);
    }

    private double getEnergyBound() {
        return this.energyBound;
    }

    private void setEnergyBound(double energyBound) {
        this.energyBound = energyBound;
    }

    private double getCapitalBound() {
        return this.capitalBound;
    }

    private void setCapitalBound(double capitalBound) {
        this.capitalBound = capitalBound;
    }

    private String getGarbageTypeBanned() {
        return this.garbageTypeBanned;
    }

    private void setGarbageTypeBanned(String garbageTypeBanned) {
        this.garbageTypeBanned = garbageTypeBanned;
    }

    private BigDecimal getTotalEnergy() {
        BigDecimal total = BigDecimal.ZERO;
        for (ProcessingData data : this.data) {
            total = total.add(BigDecimal.valueOf(data.getEnergyBalance()));
        }

        return total;
    }

    private BigDecimal getTotalCapital() {
        BigDecimal total = BigDecimal.ZERO;
        for (ProcessingData data : this.data) {
            total = total.add(BigDecimal.valueOf(data.getCapitalBalance()));
        }
        return total;
    }

}

