package mood3.interfaces;

public interface GameObjFactory {

    <E> GameObject<E> getCharacter(String... params);

}
