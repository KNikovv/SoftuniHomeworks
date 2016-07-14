package mood3.interfaces;

public interface GameObject<E> {

    String getUsername();

    int getLevel();

    E getHashedPassword();

    void setHashedPassword(E element);
}
