package customlist.interfaces;

public interface Sortable<T extends Comparable> {

    void sort(CustomList<T> customList);
}
