package tuple;

public class TupleImpl<T> implements Tuple<T> {

    private T key;
    private T value;

    public TupleImpl(T key, T value) {
        this.setKey(key);
        this.setValue(value);
    }

    @Override
    public T getKey() {
        return this.key;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    private void setKey(T key) {
        this.key = key;
    }

    private void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.key, this.value);
    }
}
