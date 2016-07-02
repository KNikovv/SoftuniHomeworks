package lineardatastructures.linkedlist;

public class MyLinkedList<E> {

    private Node first;
    private Node last;
    private int count;

    public MyLinkedList() {
        this.first = null;
    }

    public int size() {
        return this.count;
    }

    public void add(Object obj) {
        Node node = new Node(obj, null);

        if (count == 0) {
            this.first = node;
            this.last = node;
        } else {
            this.last.next = node;
            this.last = node;
        }
        this.count++;
    }

    public void remove(int index) {
        int tempIndex = 0;
        Node tempNode = this.first;
        if (index > this.count - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index not valid");
        }
        if (index == 0) { // if the index is 0 replace the current first/head with the nextone
            if (this.count == 1) { // if the count of elements is 1 make the first/head null
                this.first = null;
                this.last = null;
                this.count--;
                return;
            }
            this.first = this.first.next;
            this.count--;
            return;
        }
        while (tempNode != null) {
            //while there is element check the index before the Wanted and
            // make the element point to the element after the one to be removed
            if (index - 1 == tempIndex) {
                tempNode.next.data = tempNode.data;
                tempNode.next = tempNode.next.next;
                this.count--;
                return;
            }
            tempNode = tempNode.next;
            tempIndex++;
        }
    }

    public int firstIndexOf(Object obj) {
        Node tempNode = this.first;
        int index = -1;
        int tempIndex = 0;
        while (tempNode != null) {
            if (tempNode.data.equals(obj)) {
                return tempIndex;
            }
            tempIndex++;
            tempNode = tempNode.next;
        }
        return index;
    }

    public int lastIndexOf(Object obj) {
        Node tempNode = this.first;
        int index = -1;
        int tempIndex = 0;

        while (tempNode != null) {
            if (tempNode.data.equals(obj)) {
                index = tempIndex;
            }
            tempIndex++;
            tempNode = tempNode.next;
        }
        return index;
    }

    public void print() {
        Node temp = this.first;
        if (this.count > 0) {
            System.out.print("[");
            while (true) {
                if (temp.next == null) {
                    System.out.print(temp.data);
                    break;
                }
                System.out.print(temp.data + ", ");
                temp = temp.next;
            }
            System.out.println("]");
        } else {
            System.out.println("[,]");
        }
    }
}
