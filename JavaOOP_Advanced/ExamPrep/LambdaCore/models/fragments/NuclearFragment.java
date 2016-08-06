package bg.softuni.models.models.fragments;


import bg.softuni.models.constants.Values;
import bg.softuni.models.enums.FragmentType;

public class NuclearFragment extends BaseFragment{

    public NuclearFragment(String name, int pressureAffection) {
        super(name, pressureAffection);
        this.setType(FragmentType.Nuclear);
    }

    @Override
    protected void setPressureAffection(int value) {
        super.setPressureAffection(value * Values.NUCLEAR_FRAGMENT_MULTIPLIER);
    }

}
