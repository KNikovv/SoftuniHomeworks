package lineardatastructures.linkedlist.interfaces;

public interface MyLinkedList<E> extends Iterable<E>{

    void addLast(E element);

    void removeFirstOccurence(E element);

    int getSize();

    int firstIndexOf(E element);

    int lastIndexOf(E element);

    boolean contains(E element);
}
