package mirrorimage.core.interfaces;

import mirrorimage.models.interfaces.Wizard;

public interface WizardData {

    void addWizard(Wizard wizard);

    Wizard getWizard(int id);

    void addSpellResult(String spellResult);

    String getSpellResults();
}
