package militaryElite.models;

import militaryElite.interfaces.ILeutenantGeneral;
import militaryElite.interfaces.IPrivate;

import java.util.ArrayList;
import java.util.List;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {

    private List<IPrivate> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public List<IPrivate> getPrivates() {
        return this.privates;
    }

    @Override
    public void addPrivates(String id, List<IPrivate> allPrivates) {

        for (IPrivate iPrivate : allPrivates) {
            if (iPrivate.getID().equals(id)) {
                this.privates.add(iPrivate);
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder privatesToString = new StringBuilder();
        this.privates.forEach(p -> privatesToString.append("  ").append(p.toString()));
        return super.toString() + "Privates:\n" + privatesToString;

    }
}
