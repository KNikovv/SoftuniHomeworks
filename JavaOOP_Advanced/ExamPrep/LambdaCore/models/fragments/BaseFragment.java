package bg.softuni.models.models.fragments;

import bg.softuni.models.constants.Values;
import bg.softuni.models.enums.FragmentType;
import bg.softuni.models.models.interfaces.Fragment;

public abstract class BaseFragment implements Fragment {

    private String name;
    private FragmentType type;
    private int pressureAffection;

    protected BaseFragment(String name, int pressureAffection) {
        this.setName(name);
        this.setPressureAffection(pressureAffection);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String value) {
        this.name = value;
    }

    @Override
    public FragmentType getFragmentType() {
        return this.type;
    }

    protected void setType(FragmentType value) {
        this.type = value;
    }

    @Override
    public int getPressureAffection() {
        return this.pressureAffection;
    }

    protected void setPressureAffection(int value) {
        if (value < Values.DEFAULT_PRESSURE) {
            throw new IllegalArgumentException();
        }
        this.pressureAffection = value;
    }

}
