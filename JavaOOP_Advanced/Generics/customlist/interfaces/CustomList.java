package customlist.interfaces;

import java.util.List;

public interface CustomList<T extends Comparable> extends Addable<T>, Removable<T>, Containable<T>, Swapable,
        Printable {

    List<T> getData();

    int countGreaterThan(T element);

    T getMax();

    T getMin();
}
