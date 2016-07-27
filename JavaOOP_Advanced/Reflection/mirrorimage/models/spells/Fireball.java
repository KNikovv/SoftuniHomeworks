package mirrorimage.models.spells;

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

        System.out.println((String.format("%s %d casts Fireball for %d damage",
                wizardName,
                wizardId,
                damageDone)));
    }
}
