package bg.softuni.models.models.fragments;

import bg.softuni.models.constants.Values;
import bg.softuni.models.enums.FragmentType;

public class CoolingFragment extends BaseFragment {


    public CoolingFragment(String name, int pressureAffection) {
        super(name, pressureAffection);
        this.setType(FragmentType.Cooling);
    }

    @Override
    protected void setPressureAffection(int value) {
        super.setPressureAffection(value * Values.COOLING_FRAGMENT_MULTIPLIER);
    }

}
