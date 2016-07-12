package militaryElite;

import militaryElite.interfaces.ISoldier;

import java.util.ArrayList;
import java.util.List;

public class MilitaryBase {

    private List<ISoldier> allPrivates;

    public MilitaryBase() {
        this.allPrivates = new ArrayList<>();
    }

    public void addPrivate(ISoldier privateSoldier) {
        this.allPrivates.add(privateSoldier);
    }
    public List<ISoldier> getAllPrivates(){
        return this.allPrivates;
    }
}
