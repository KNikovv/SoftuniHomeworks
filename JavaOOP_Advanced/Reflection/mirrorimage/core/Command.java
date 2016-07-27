package mirrorimage.core;

import mirrorimage.core.interfaces.Executable;
import mirrorimage.enums.SpellType;
import mirrorimage.factories.SpellFactory;
import mirrorimage.models.interfaces.Spell;
import mirrorimage.models.interfaces.Wizard;

public class Command implements Executable {


    @Override
    public void execute(String[] args) {
        int mageId = Integer.valueOf(args[0]);
        SpellType spellType = SpellType.valueOf(args[1]);

        Wizard wizard = WizardDataImpl.getInstance().getWizard(mageId);
        Spell spell = SpellFactory.createSpell(spellType, wizard);

        wizard.castSpell(spell);
    }
}
