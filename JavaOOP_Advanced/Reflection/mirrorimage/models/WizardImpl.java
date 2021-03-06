package mirrorimage.models;

import mirrorimage.factories.SpellFactory;
import mirrorimage.models.interfaces.Listener;
import mirrorimage.models.interfaces.Spell;
import mirrorimage.models.interfaces.Wizard;

import java.util.LinkedList;
import java.util.List;

public class WizardImpl implements Wizard {

    private String name;
    private int id;
    private int magicalPower;
    private List<Listener> listeners;

    public WizardImpl(int id, String name, int magicalPower) {
        this.setId(id);
        this.setName(name);
        this.setMagicalPower(magicalPower);
        this.listeners = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getMagicalPower() {
        return magicalPower;
    }

    private void setMagicalPower(int magicalPower) {
        this.magicalPower = magicalPower;
    }

    @Override
    public void castSpell(Spell spell) {
        List<Listener> copyListeners = new LinkedList<>(this.listeners);
        spell.cast();
        this.notifyListeners(spell, copyListeners);
    }

    @Override
    public void update(Spell spell) {
        Spell spellToCall = SpellFactory.createSpell(spell.getSpellType(), this);
        this.castSpell(spellToCall);
    }

    @Override
    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void notifyListeners(Spell spell, List<Listener> copyListeners) {
        for (Listener listener : copyListeners) {
            listener.update(spell);
        }
    }

    @Override
    public int getListenersCount() {
        return this.listeners.size();
    }

}
