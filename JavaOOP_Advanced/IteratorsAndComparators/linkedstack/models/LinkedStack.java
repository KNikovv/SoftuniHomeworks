package lineardatastructures.linkedstack.models;

import lineardatastructures.linkedstack.MyStackEmptyException;
import lineardatastructures.linkedstack.interfaces.MyStack;

import java.util.Iterator;

public class LinkedStack<T> implements MyStack<T>{

    private Node<T> topNode;
    private int count;

    public LinkedStack() {
        this.topNode = null;
    }

    @Override
    public void push(T element) {
        this.topNode = new Node<T>(element, this.topNode);
        this.count++;
    }

    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new MyStackEmptyException();
        }
        T returnValue = this.topNode.getData();
        this.topNode = this.topNode.getNext();
        this.count--;
        return returnValue;
    }

    @Override
    public T peek() {
        return this.topNode.getData();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.count;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> tempNode = topNode;

            @Override
            public boolean hasNext() {
                return tempNode != null;
            }

            @Override
            public T next() {
                T element = tempNode.getData();
                tempNode = tempNode.getNext();
                return element;
            }
        };
    }
}
