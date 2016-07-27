package mirrorimage.models.interfaces;

import java.util.List;

public interface Observer {

    void addListener(Listener listener);

    void removeListener(Listener listener);

    void notifyListeners(Spell spell, List<Listener> listeners);
}
