package customlist.models;

import customlist.interfaces.CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {

    private List<T> data;

    public CustomListImpl() {
        this.data = new ArrayList<T>();
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        T elementOne = this.data.get(firstIndex);
        T elementTwo = this.data.get(secondIndex);
        this.data.set(firstIndex, elementTwo);
        this.data.set(secondIndex, elementOne);
    }

    @Override
    public T remove(int index) {
        return this.data.remove(index);
    }

    @Override
    public void add(T element) {
        this.data.add(element);
    }

    @Override
    public boolean contains(T element) {
        return this.data.contains(element);
    }


    @Override
    public int countGreaterThan(T element) {
        int count = 0;

        for (T tElement : this.data) {
            if (tElement.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    @Override
    public T getMax() {
        T maxElement = this.data.get(0);
        for (T element : this.data) {
            if (element.compareTo(maxElement) > 0) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    @Override
    public T getMin() {
        T minElement = this.data.get(0);
        for (T element : this.data) {
            if (element.compareTo(minElement) < 0) {
                minElement = element;
            }
        }
        return minElement;
    }

    @Override
    public T get(int index) {
        return this.data.get(index);
    }

    @Override
    public int getSize() {
        return this.data.size();
    }

    @Override
    public void print() {
        for (T element : this.data) {
            System.out.println(element);
        }
    }
}
