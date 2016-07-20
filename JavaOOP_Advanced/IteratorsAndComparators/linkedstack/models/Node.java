package lineardatastructures.linkedstack.models;

public class Node<T> {

    private Node<T> next;
    private T data;

    public Node(T data, Node<T> next) {
        this.next = next;
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    private void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    private void setData(T data) {
        this.data = data;
    }
}
