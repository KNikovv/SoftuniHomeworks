package militaryElite.interfaces;

import java.util.List;

public interface ICommando {

    List<IMission> getMissions();

    void addMission(IMission mission);
}
