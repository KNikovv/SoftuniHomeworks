package bg.softuni.models.models.interfaces;

import bg.softuni.models.enums.FragmentType;

public interface Fragment extends PressureAffectable,Nameable {

    FragmentType getFragmentType();

}
