package bg.softuni.models.models.interfaces;

public interface Core extends FragmentManipulator, Nameable, StatusUpdatable {

    long getPressure();

    long getDurability();

    int getFragmentCount();
}
