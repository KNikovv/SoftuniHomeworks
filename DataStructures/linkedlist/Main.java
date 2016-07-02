package lineardatastructures.linkedlist;

public class Main {

    public static void main(String[] args) {

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.add(6);
        myLinkedList.add(8);
        myLinkedList.add(6);
        myLinkedList.print();
        System.out.println(myLinkedList.firstIndexOf(6));
        System.out.println(myLinkedList.lastIndexOf(6));
    }
}
