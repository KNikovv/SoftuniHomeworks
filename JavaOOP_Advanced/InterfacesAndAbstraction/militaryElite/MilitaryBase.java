package militaryElite;

import militaryElite.interfaces.IPrivate;

import java.util.ArrayList;
import java.util.List;

public class MilitaryBase {

    private List<IPrivate> allPrivates;

    public MilitaryBase() {
        this.allPrivates = new ArrayList<>();
    }

    public void addPrivate(IPrivate privateSoldier) {
        this.allPrivates.add(privateSoldier);
    }
    public List<IPrivate> getAllPrivates(){
        return this.allPrivates;
    }
}
