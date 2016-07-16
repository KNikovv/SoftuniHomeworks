package collectionhierarchy.models;

import collectionhierarchy.interfaces.IAdd;
import collectionhierarchy.interfaces.IRemove;

import java.util.LinkedList;

public class AddRemoveCollection implements IAdd, IRemove {

    private LinkedList<String> list;

    public AddRemoveCollection() {
        this.list = new LinkedList<String>();
    }

    @Override
    public String remove() {
        return this.list.removeLast();
    }

    @Override
    public int add(String str) {
        this.list.addFirst(str);
        return 0;
    }

}
