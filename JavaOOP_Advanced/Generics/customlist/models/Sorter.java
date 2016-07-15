package customlist.models;

import customlist.interfaces.CustomList;
import customlist.interfaces.Sortable;

import java.util.Comparator;

public class Sorter<T extends Comparable> implements Sortable<T> {

    private CustomList<T> list;

    public Sorter(CustomList<T> list) {
        this.list = list;
    }

    @Override
    public void sort() {

        this.list.getData().sort(Comparator.naturalOrder());
    }
}
