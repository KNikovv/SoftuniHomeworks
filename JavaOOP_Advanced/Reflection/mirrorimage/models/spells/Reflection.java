package mirrorimage.models.spells;

import mirrorimage.core.WizardDataImpl;
import mirrorimage.factories.WizardFactory;
import mirrorimage.core.interfaces.WizardData;
import mirrorimage.enums.SpellType;
import mirrorimage.models.interfaces.Wizard;

public class Reflection extends AbstractSpell {

    private static final int REFLECTION_COUNT = 2;

    public Reflection(SpellType spellType, Wizard wizard) {
        super(spellType, wizard);
    }

    @Override
    public void cast() {
        Wizard wizard = this.getWizard();
        int magicalPower = this.getWizard().getMagicalPower();

        if (wizard.getListenersCount() < REFLECTION_COUNT) {
            createReflections(wizard, magicalPower);
        }
        String wizardName = this.getWizard().getName();
        int wizardId = this.getWizard().getId();

        String spellResult = String.format("%s %d casts Reflection", wizardName,wizardId);

        WizardData wizardData = WizardDataImpl.getInstance();
        wizardData.addSpellResult(spellResult);
    }

    private void createReflections(Wizard wizard, int magicalPower) {
        for (int i = 0; i < 2; i++) {
            Wizard newWizard = WizardFactory.createWizard(wizard.getName(), magicalPower / REFLECTION_COUNT);

            addMageToData(newWizard);
            wizard.addListener(newWizard);
        }
    }

    private void addMageToData(Wizard wizard) {
        WizardData wizardData = WizardDataImpl.getInstance();
        wizardData.addWizard(wizard);
    }
}
