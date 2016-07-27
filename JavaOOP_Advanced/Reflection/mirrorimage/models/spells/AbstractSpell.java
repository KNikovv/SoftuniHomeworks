package mirrorimage.models.spells;

import mirrorimage.enums.SpellType;
import mirrorimage.models.interfaces.Spell;
import mirrorimage.models.interfaces.Wizard;

public abstract class AbstractSpell implements Spell {

    private SpellType spellType;
    private Wizard wizard;

    protected AbstractSpell(SpellType spellType, Wizard wizard) {
        this.spellType = spellType;
        this.wizard = wizard;
    }

    public Wizard getWizard() {
        return this.wizard;
    }

    @Override
    public SpellType getSpellType() {
        return this.spellType;
    }

    @Override
    public abstract void cast();

}
