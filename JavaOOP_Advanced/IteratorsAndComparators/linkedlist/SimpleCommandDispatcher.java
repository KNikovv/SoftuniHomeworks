package lineardatastructures.linkedlist;

import lineardatastructures.linkedlist.interfaces.MyLinkedList;
import lineardatastructures.linkedlist.models.MyLinkedListImpl;

public class SimpleCommandDispatcher {

    private MyLinkedList<Integer> myLinkedList;

    public SimpleCommandDispatcher() {
        this.myLinkedList = new MyLinkedListImpl<>();
    }

    public void dispatch(String command, Integer number) {
        switch (command) {
            case "Add":
                this.myLinkedList.addLast(number);
                break;
            case "Remove":
                this.myLinkedList.removeFirstOccurence(number);
                break;
            case "Print":
                printSize();
                printCollection();
                break;
        }
    }

    private void printSize() {
        System.out.println(this.myLinkedList.getSize());
    }

    private void printCollection() {

        for (Integer number : this.myLinkedList) {
            System.out.print(number + " ");
        }

    }
}
