package militaryElite.models;

import militaryElite.interfaces.ICommando;
import militaryElite.interfaces.IMission;

import java.util.ArrayList;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {

    private List<IMission> missions;

    public Commando(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public List<IMission> getMissions() {
        return this.missions;
    }

    @Override
    public void addMission(IMission mission) {
        if (mission.getState() != null) {
            this.missions.add(mission);
        }
    }

    @Override
    public String toString() {
        StringBuilder missionsToString = new StringBuilder();
        missionsToString.append("Missions:\n");
        this.missions.forEach(missionsToString::append);
        return super.toString() + missionsToString;
    }
}
