package bg.softuni.models.models.cores;

import bg.softuni.models.collection.LStack;
import bg.softuni.models.collection.LStackImpl;
import bg.softuni.models.constants.NameProvider;
import bg.softuni.models.constants.Values;
import bg.softuni.models.enums.CoreStatus;
import bg.softuni.models.enums.FragmentType;
import bg.softuni.models.models.interfaces.Core;
import bg.softuni.models.models.interfaces.Fragment;

public class BaseCore implements Core {

    private String name;
    private int durability;
    private LStack<Fragment> fragments;

    protected BaseCore(int durability) {
        this.setName();
        this.setDurability(durability);
        this.fragments = new LStackImpl<>();
    }

    public String getName() {
        return name;
    }

    private void setName() {
        this.name = NameProvider.getNextName();
    }

    public long getDurability() {

        long durability = this.durability - this.getPressure();

        return durability > Values.DEFAULT_DURABILITY ? durability : Values.DEFAULT_DURABILITY;
    }

    protected void setDurability(int durability) {
        if (durability < Values.DEFAULT_DURABILITY) {
            throw new IllegalArgumentException();
        }
        this.durability = durability;
    }

    public long getPressure() {
        long pressure = Values.DEFAULT_PRESSURE;

        for (Fragment fragment : this.fragments) {
            switch (fragment.getFragmentType()) {
                case Nuclear:
                    pressure += fragment.getPressureAffection();
                    break;
                case Cooling:
                    pressure -= fragment.getPressureAffection();
                    break;
            }
        }
        return pressure > Values.DEFAULT_PRESSURE ? pressure : Values.DEFAULT_PRESSURE;
    }

    @Override
    public CoreStatus getStatus() {
        return this.getPressure() > Values.DEFAULT_PRESSURE ? CoreStatus.CRITICAL : CoreStatus.NORMAL;
    }

    @Override
    public Fragment attachFragment(Fragment fragment) {
        if (this.checkIsFragmenDifferentType(fragment)) {
            throw new IllegalArgumentException();
        }
        Fragment attached = this.fragments.push(fragment);
        return attached;
    }

    @Override
    public Fragment detachFragment() {
        Fragment detached = this.fragments.pop();
        return detached;
    }

    @Override
    public Fragment peekFragment() {
        Fragment topFragment = this.fragments.peek();
        return topFragment;
    }

    @Override
    public int getFragmentCount() {
        return this.fragments.size();
    }

    @Override
    public String toString() {
        return String.format("Core %s:\n####Durability: %d\n####Status: %s\n",
                this.getName(),
                this.getDurability(),
                this.getStatus());
    }

    private boolean checkIsFragmenDifferentType(Fragment fragment) {
        return !fragment.getFragmentType().equals(FragmentType.Nuclear) &&
                !fragment.getFragmentType().equals(FragmentType.Cooling);
    }

}
