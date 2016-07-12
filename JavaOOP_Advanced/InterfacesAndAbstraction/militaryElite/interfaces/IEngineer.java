package militaryElite.interfaces;

import java.util.List;

public interface IEngineer {

    List<IRepair> getRepairs();

    void addRepair(String partName,int hoursWorked);
}
