package customlist.models;

import customlist.interfaces.CustomList;
import customlist.interfaces.Sortable;

public class Sorter<T extends Comparable<T>> implements Sortable<T> {

    @Override
    public void sort(CustomList<T> customList) {
        for (int i = 0; i < customList.getSize(); i++) {
            T element = customList.get(i);
            for (int j = i + 1; j < customList.getSize(); j++) {
                T elementToSwap = customList.get(j);
                if (element.compareTo(elementToSwap) > 0) {
                    customList.swap(i, j);
                }
            }
        }
    }
}
