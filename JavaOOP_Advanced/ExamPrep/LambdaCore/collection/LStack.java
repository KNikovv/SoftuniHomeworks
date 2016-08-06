package bg.softuni.models.collection;

import bg.softuni.models.models.interfaces.Fragment;

public interface LStack<T extends Fragment> extends Iterable<T> {

    T push(T element);

    T pop();

    int size();

    T peek();

    Boolean isEmpty();

}
