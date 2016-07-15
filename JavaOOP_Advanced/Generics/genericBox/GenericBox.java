package genericBox;

import java.util.ArrayList;
import java.util.List;

public class GenericBox<T> {

    private List<T> listOfItems;

    public GenericBox() {
        this.listOfItems = new ArrayList<T>();
    }

    public void addItem(T element) {
        this.listOfItems.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.listOfItems) {
            sb.append(String.format("%s: %s%n", element.getClass().getName(), element));
        }
        return sb.toString();
    }
}
