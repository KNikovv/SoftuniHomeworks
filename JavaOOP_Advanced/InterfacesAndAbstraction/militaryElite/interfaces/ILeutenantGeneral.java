package militaryElite.interfaces;

import java.util.List;

public interface ILeutenantGeneral {

    List<IPrivate> getPrivates();

    void addPrivates(String id , List<IPrivate> allPrivates);
}
