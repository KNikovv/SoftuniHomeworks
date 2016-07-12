package militaryElite.models;

import militaryElite.interfaces.ILeutenantGeneral;
import militaryElite.interfaces.ISoldier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {

    private List<ISoldier> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public List<ISoldier> getPrivates() {
        return this.privates;
    }

    @Override
    public void addPrivates(String id, List<ISoldier> allPrivates) {
        List<ISoldier> temp = allPrivates
                .stream()
                .filter(p -> p.getID().equals(id))
                .collect(Collectors.toList());

        this.privates.addAll(temp);
    }

    @Override
    public String toString() {
        StringBuilder privatesToString = new StringBuilder();
        this.privates.forEach(p -> privatesToString.append("  ").append(p.toString()));
        return super.toString() + "Privates: \n" + privatesToString;

    }
}
