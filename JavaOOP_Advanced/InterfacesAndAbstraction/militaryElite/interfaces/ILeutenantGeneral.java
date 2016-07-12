package militaryElite.interfaces;

import java.util.List;

public interface ILeutenantGeneral {

    List<ISoldier> getPrivates();

    void addPrivates(String id , List<ISoldier> allPrivates);
}
