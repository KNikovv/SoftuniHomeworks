package mirrorimage.factories;

import mirrorimage.enums.SpellType;
import mirrorimage.models.interfaces.Spell;
import mirrorimage.models.interfaces.Wizard;
import mirrorimage.models.spells.Fireball;
import mirrorimage.models.spells.Reflection;

public class SpellFactory {

    public static Spell createSpell(SpellType spellType, Wizard wizard) {

        switch (spellType) {
            case REFLECTION:
                return new Reflection(spellType, wizard);
            case FIREBALL:
                return new Fireball(spellType, wizard);
            default:
                throw new IllegalArgumentException("No such spell");
        }
    }
}
