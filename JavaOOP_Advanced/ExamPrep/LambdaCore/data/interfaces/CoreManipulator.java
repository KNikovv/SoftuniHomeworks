package bg.softuni.models.data.interfaces;

import bg.softuni.models.models.interfaces.Core;
import bg.softuni.models.models.interfaces.Fragment;

public interface CoreManipulator {

    void addCore(Core core);

    void removeCore(String coreName);

    void selectCore(String coreName);

    void attachFragmentToSelectedCore(Fragment fragment);

    String detachFragmentFromSelectedCore();

    String getSelectedCoreName();
}
