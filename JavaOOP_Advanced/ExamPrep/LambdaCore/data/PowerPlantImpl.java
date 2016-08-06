package bg.softuni.models.data;

import bg.softuni.models.constants.Messages;
import bg.softuni.models.data.interfaces.PowerPlant;
import bg.softuni.models.models.interfaces.Core;
import bg.softuni.models.models.interfaces.Fragment;

import java.util.LinkedHashMap;
import java.util.Map;

public class PowerPlantImpl implements PowerPlant {

    private Map<String, Core> coresByName;
    private Core currentlySelectedCore;

    public PowerPlantImpl() {
        this.coresByName = new LinkedHashMap<>();
        this.currentlySelectedCore = null;
    }

    @Override
    public void addCore(Core core) {
        this.coresByName.put(core.getName(), core);
    }

    @Override
    public void removeCore(String coreName) {
        if (!this.coresByName.containsKey(coreName)) {
            throw new IllegalArgumentException();
        }
        if (this.currentlySelectedCore.getName().equals(coreName)) {
            this.currentlySelectedCore = null;
        }
        this.coresByName.remove(coreName);
    }

    @Override
    public void selectCore(String coreName) {
        if (!this.coresByName.containsKey(coreName)) {
            throw new IllegalArgumentException();
        }
        Core core = this.coresByName.get(coreName);
        this.currentlySelectedCore = core;
    }

    @Override
    public void attachFragmentToSelectedCore(Fragment fragment) {
        if (this.currentlySelectedCore == null) {
            throw new IllegalArgumentException();
        }

        this.currentlySelectedCore.attachFragment(fragment);
    }

    @Override
    public String detachFragmentFromSelectedCore() {
        if (this.currentlySelectedCore == null ||
                this.currentlySelectedCore.peekFragment() == null) {
            throw new IllegalArgumentException();
        }

        Fragment detached = this.currentlySelectedCore.detachFragment();
        return String.format(Messages.SUCCESSFULLY_DETACHED_FRAGMENT_MESSAGE,
                detached.getName(),
                this.currentlySelectedCore.getName());
    }

    @Override
    public String getSelectedCoreName() {
        return this.currentlySelectedCore.getName();
    }

    @Override
    public String getStatusReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("Lambda Core Power Plant Status:").append(System.lineSeparator());
        builder.append("Total Durability: ").append(this.getTotalDurability()).append(System.lineSeparator());
        builder.append("Total Cores: ").append(this.getTotalCores()).append(System.lineSeparator());
        builder.append("Total Fragments: ").append(this.getTotalFragments()).append(System.lineSeparator());
        for (Core core : this.coresByName.values()) {
            builder.append(core.toString());
        }
        return builder.toString();
    }

    private long getTotalDurability() {
        return this.coresByName.values().stream().mapToLong(Core::getDurability).sum();
    }

    private int getTotalCores() {
        return this.coresByName.size();
    }

    private int getTotalFragments() {
        return this.coresByName.values().stream().mapToInt(Core::getFragmentCount).sum();
    }
}
