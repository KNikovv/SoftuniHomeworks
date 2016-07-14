package mood3.interfaces;

public interface GameObject<E> {

    String getUsername();

    int getLevel();

    void setPoints();

    E getHashedPassword();

    void setHashedPassword(E element);
}
