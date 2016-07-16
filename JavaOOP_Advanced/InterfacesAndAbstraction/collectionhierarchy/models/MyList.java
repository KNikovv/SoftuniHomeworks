package collectionhierarchy.models;

import collectionhierarchy.interfaces.IAdd;
import collectionhierarchy.interfaces.IRemove;
import collectionhierarchy.interfaces.IUsed;

import java.util.LinkedList;

public class MyList implements IAdd, IRemove, IUsed {

    private LinkedList<String> list;

    public MyList() {
        this.list = new LinkedList<>();
    }

    @Override
    public int add(String str) {
        this.list.addFirst(str);
        return 0;
    }


    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public String remove() {
        return this.list.removeFirst();
    }
}
