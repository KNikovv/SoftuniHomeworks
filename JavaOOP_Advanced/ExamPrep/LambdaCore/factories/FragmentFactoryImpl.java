package bg.softuni.models.factories;

import bg.softuni.models.factories.interfaces.FragmentFactory;
import bg.softuni.models.models.interfaces.Fragment;

public class FragmentFactoryImpl implements FragmentFactory {

    private static final String FRAGMENT_PACKAGE = "bg.softuni.models.models.fragments.";
    private static final String FRAGMENT_SUFFIX = "Fragment";

    @Override
    @SuppressWarnings("unchecked")
    public Fragment createFragment(String type, String name, int pressureAffection) throws
            ReflectiveOperationException {
        Fragment fragment;
        Class<Fragment> fragmentClass = (Class<Fragment>) Class.forName(FRAGMENT_PACKAGE + type + FRAGMENT_SUFFIX);
        fragment = fragmentClass
                .getDeclaredConstructor(String.class, int.class)
                .newInstance(name, pressureAffection);
        return fragment;
    }
}
