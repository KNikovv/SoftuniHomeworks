package bg.softuni.models.factories.interfaces;

import bg.softuni.models.models.interfaces.Fragment;

public interface FragmentFactory {

    Fragment createFragment(String type,String name , int pressureAffection) throws ReflectiveOperationException;
}
