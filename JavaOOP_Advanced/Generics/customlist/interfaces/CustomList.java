package customlist.interfaces;

public interface CustomList<T extends Comparable> extends Addable<T>, Removable<T>, Containable<T>, Swapable,
        Printable {

    int countGreaterThan(T element);

    T getMax();

    T getMin();

    int getSize();

    T get(int index);
}
