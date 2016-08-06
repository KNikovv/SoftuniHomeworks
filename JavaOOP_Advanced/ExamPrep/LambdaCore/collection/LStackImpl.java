package bg.softuni.models.collection;

import bg.softuni.models.models.interfaces.Fragment;

import java.util.Iterator;
import java.util.LinkedList;

public class LStackImpl<T extends Fragment> implements LStack<T>,Iterable<T> {

    private LinkedList<T> innerList;

    public LStackImpl() {
        this.innerList = new LinkedList<>();
    }

    public int size() {
        return this.innerList.size();
    }

    public T push(T item) {
        this.innerList.addLast(item);
        return item;
    }

    public T pop() {
        T removedItem = this.innerList.removeLast();
        return removedItem;
    }

    public T peek() {
        T peekedItem = this.innerList.getFirst();
        return peekedItem;
    }

    public Boolean isEmpty() {
        return this.innerList.isEmpty();
    }


    @Override
    public Iterator<T> iterator() {
        return this.innerList.iterator();
    }
}