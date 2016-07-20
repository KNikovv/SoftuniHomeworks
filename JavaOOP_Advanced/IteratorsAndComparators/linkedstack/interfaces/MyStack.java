package lineardatastructures.linkedstack.interfaces;

public interface MyStack<T> extends Iterable<T> {

    void push(T element);

    T pop();

    T peek();

    int size();

    boolean isEmpty();

}
