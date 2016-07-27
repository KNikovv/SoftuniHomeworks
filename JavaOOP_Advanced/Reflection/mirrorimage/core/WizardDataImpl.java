package mirrorimage.core;

import mirrorimage.core.interfaces.WizardData;
import mirrorimage.models.interfaces.Wizard;

import java.util.LinkedList;
import java.util.List;

public class WizardDataImpl implements WizardData {

    private static WizardDataImpl instance = new WizardDataImpl();
    private static List<Wizard> wizards;

    public static WizardData getInstance() {
        return instance;
    }

    public WizardDataImpl() {
        if (wizards == null) {
            wizards = new LinkedList<>();
        }
    }

    @Override
    public void addWizard(Wizard wizard) {
        wizards.add(wizard);
    }

    @Override
    public Wizard getWizard(int id) {
        for (Wizard wizard : wizards) {
            if (wizard.getId() == id) {
                return wizard;
            }
        }
        throw new IllegalArgumentException("No such wizard");
    }
}
