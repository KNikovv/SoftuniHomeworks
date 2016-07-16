package collectionhierarchy.models;

import collectionhierarchy.interfaces.IAdd;

import java.util.ArrayList;
import java.util.List;

public class AddCollection implements IAdd {

    private List<String> list;

    public AddCollection() {
        this.list = new ArrayList<String>(100);
    }

    @Override
    public int add(String str) {
        this.list.add(str);
        return this.list.size()-1;
    }
}
