package genericSwapMethod;

import java.util.List;

public class GenericBox<T> {

    private List<T> genericList;

    public GenericBox(List<T> genericList) {
        this.genericList = genericList;
    }

    private List<T> getGenericList() {
        return genericList;
    }

    private void setGenericList(List<T> genericList) {
        this.genericList = genericList;
    }

    public void swapIndexes(int indexOne, int indexTwo) {
        T elementOne = this.genericList.get(indexOne);
        T elementTwo = this.genericList.get(indexTwo);
        this.genericList.set(indexOne,elementTwo);
        this.genericList.set(indexTwo,elementOne);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.genericList) {
            sb.append(String.format("%s: %s%n", element.getClass().getName(), element));
        }
        return sb.toString();
    }
}
