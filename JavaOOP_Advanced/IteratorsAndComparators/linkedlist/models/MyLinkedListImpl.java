package lineardatastructures.linkedlist.models;

import lineardatastructures.linkedlist.interfaces.MyLinkedList;

import java.util.Iterator;

public class MyLinkedListImpl<E> implements MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int count;

    public MyLinkedListImpl() {
        this.head = null;
    }

    @Override
    public int getSize() {
        return this.count;
    }

    @Override
    public void addLast(E element) {
        Node<E> node = new Node<E>(element, null, this.tail);

        if (count == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.count++;
    }

    @Override
    public void removeFirstOccurence(E element) {
        if (this.contains(element)) {

            Node<E> tempNode = this.head;

            while (tempNode != null) {
                if (tempNode.getValue().equals(element)) {

                    if (tempNode == this.head) { // if element is the head
                        this.head = tempNode.getNext();
                        break;
                    }

                    if ((tempNode == this.tail)) {
                        this.tail = tempNode.getPrevious();
                        this.tail.setNext(null);
                        break;
                    }
                    tempNode.getPrevious().setNext(tempNode.getNext());
                    tempNode.getNext().setPrevious(tempNode.getPrevious());
                    break;
                }
                tempNode = tempNode.getNext();
            }

            this.count--;
            tempNode = null;
        }
    }

    @Override
    public int firstIndexOf(E element) {
        Node<E> tempNode = this.head;
        int index = -1;
        int tempIndex = 0;
        while (tempNode != null) {
            if (tempNode.getValue().equals(element)) {
                return tempIndex;
            }
            tempIndex++;
            tempNode = tempNode.getNext();
        }
        return index;
    }

    @Override
    public int lastIndexOf(E element) {
        Node<E> tempNode = this.head;
        int index = -1;
        int tempIndex = 0;

        while (tempNode != null) {
            if (tempNode.getValue().equals(element)) {
                index = tempIndex;
            }
            tempIndex++;
            tempNode = tempNode.getNext();
        }
        return index;
    }

    @Override
    public boolean contains(E element) {
        return this.firstIndexOf(element) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> currentNode = head;

            @Override
            public boolean hasNext() {
                return this.currentNode != null;
            }

            @Override
            public E next() {
                E element = this.currentNode.getValue();
                this.currentNode = this.currentNode.getNext();

                return element;
            }
        };
    }
}
