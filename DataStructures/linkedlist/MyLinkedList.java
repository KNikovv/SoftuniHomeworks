package lineardatastructures.linkedlist;

public class MyLinkedList<E> {

    private Node start;
    private Node end;
    private int count;

    public MyLinkedList() {
        this.start = null;
    }

    public int size() {
        return this.count;
    }

    public void add(Object obj) {
        Node node = new Node(obj, null);

        if (count == 0) {
            this.start = node;
            this.end = node;
        } else {
            this.end.next = node;
            this.end = node;
        }
        this.count++;
    }

    public void remove(int index) {
        int tempIndex = 0;
        Node tempNode = this.start;
        if (index > this.count - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index not valid");
        }
        if (index == 0) { // if the index is 0 replace the current start/head with the nextone
            if (this.count == 1) { // if the count of elements is 1 make the start/head null
                this.start = null;
                this.end = null;
                this.count--;
                return;
            }
            this.start = this.start.next;
            this.count--;
            return;
        }
        while (tempNode != null) {
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
        Node tempNode = this.start;
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
        Node tempNode = this.start;
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
        Node temp = this.start;
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
