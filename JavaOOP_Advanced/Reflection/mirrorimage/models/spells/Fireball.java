package mirrorimage.models.spells;

import mirrorimage.core.WizardDataImpl;
import mirrorimage.core.interfaces.WizardData;
import mirrorimage.enums.SpellType;
import mirrorimage.models.interfaces.Wizard;

public class Fireball extends AbstractSpell {

    public Fireball(SpellType spellType, Wizard wizard) {
        super(spellType, wizard);
    }

    @Override
    public void cast() {
        String wizardName = this.getWizard().getName();
        int wizardId = this.getWizard().getId();
        int damageDone = this.getWizard().getMagicalPower();

       String spellResult = String.format("%s %d casts Fireball for %d damage",
                wizardName,
                wizardId,
                damageDone);
        WizardData wizardData = WizardDataImpl.getInstance();
        wizardData.addSpellResult(spellResult);
    }
}
