package listyiterator.models;

import listyiterator.interfaces.ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIteratorImpl<E> implements ListyIterator<E>, Iterable<E> {

    private List<E> internalList;
    private int index;

    public ListyIteratorImpl(List<E> internalList) {
        this.setInternalList(internalList);
        this.index = 0;
    }

    private void setInternalList(List<E> internalList) {
        this.internalList = internalList;
    }

    public List<E> getInternalList() {
        return this.internalList;
    }

    @Override
    public int getSize() {
        return this.internalList.size();
    }

    @Override
    public void printAll() {
        for(E element : this.internalList){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    @Override
    public boolean move() {
        if (this.index + 1 < this.getSize()) {
            this.index++;
            return true;
        }
        return false;
    }

    @Override
    public boolean listyHasNext() {
        return this.getSize() > this.index + 1;
    }

    @Override
    public void print() {
        System.out.println(this.internalList.get(this.index));
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return getInternalList().get(currentIndex) != null;
            }

            @Override
            public E next() {
                return getInternalList().get(currentIndex++);
            }
        };
    }

}
