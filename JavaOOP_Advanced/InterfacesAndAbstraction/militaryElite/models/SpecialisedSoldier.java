package militaryElite.models;

import militaryElite.interfaces.ISpecialisedSoldier;

public class SpecialisedSoldier extends Private implements ISpecialisedSoldier {

    private String corps;

    protected SpecialisedSoldier(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps) {
        if (corps.equals("Marines") || corps.equals("Airforces")) {
            this.corps = corps;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Corps: %s\n", this.corps);
    }
}
