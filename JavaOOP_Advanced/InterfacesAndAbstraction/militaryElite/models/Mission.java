package militaryElite.models;

import militaryElite.interfaces.IMission;

public class Mission implements IMission {

    String codeName;
    String state;

    public Mission(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    private void setState(String state) {
        if (state.equals("inProgress") || state.equals("Finished")) {
            this.state = state;
        }
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        //
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s\n",this.getCodeName(),this.getState());
    }
}
