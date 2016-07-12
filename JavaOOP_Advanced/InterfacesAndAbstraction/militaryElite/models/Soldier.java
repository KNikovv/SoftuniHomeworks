package militaryElite.models;

import militaryElite.interfaces.ISoldier;

public abstract class Soldier implements ISoldier {

    private String id;
    private String firstName;
    private String lastName;

    protected Soldier(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s ",
                this.getFirstName(),
                this.getLastName(),
                this.getID());
    }
}
