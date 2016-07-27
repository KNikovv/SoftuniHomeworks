package mirrorimage.models.interfaces;

import mirrorimage.enums.SpellType;

public interface Spell {

    void cast();

    SpellType getSpellType();

    Wizard getWizard();
}
