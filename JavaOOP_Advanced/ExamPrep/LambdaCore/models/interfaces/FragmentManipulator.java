package bg.softuni.models.models.interfaces;

import bg.softuni.models.models.interfaces.Fragment;

public interface FragmentManipulator {

    Fragment attachFragment(Fragment fragment);

    Fragment detachFragment();

    Fragment peekFragment();
}
