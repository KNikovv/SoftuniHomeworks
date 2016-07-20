package lineardatastructures.linkedlist.models;

public class Node<E> {

    private Node<E> next;
    private Node<E> previous;
    private E data;

    public Node(E data, Node<E> next,Node<E> previous) {
        this.next = next;
        this.previous = previous;
        this.data = data;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }
    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getValue() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
