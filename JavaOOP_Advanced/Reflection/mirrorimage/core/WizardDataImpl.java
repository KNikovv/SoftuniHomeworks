package mirrorimage.core;

import mirrorimage.core.interfaces.WizardData;
import mirrorimage.models.interfaces.Wizard;

import java.util.LinkedList;
import java.util.List;

public class WizardDataImpl implements WizardData {

    private static WizardDataImpl instance = new WizardDataImpl();
    private static List<Wizard> wizards;
    private static List<String> allSpellResults;

    public static WizardData getInstance() {
        return instance;
    }

    public WizardDataImpl() {
        if (wizards == null) {
            wizards = new LinkedList<>();
            allSpellResults = new LinkedList<>();
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

    @Override
    public void addSpellResult(String spellResult) {
        allSpellResults.add(spellResult);
    }

    @Override
    public String getSpellResults() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.join(System.lineSeparator(),allSpellResults));

        return builder.toString();
    }
}
