package mood3.models;

import mood3.interfaces.GameObject;

public abstract class Character<E,P extends Number> implements GameObject<E> {
    private static final int SUBSTRING_IMPL = 4;
    private String userName;

    private int level;

    private E hashedPassword;

    protected P specialPoints;

    public Character(String userName, int level, P specialPoints) {
        this.setUserName(userName);
        this.setLevel(level);
        this.setSpecialPoints(specialPoints);
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public E getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public void setHashedPassword(E hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    private void setSpecialPoints(P specialPoints) {
        this.specialPoints = specialPoints;
    }

    @Override
    public String toString() {
        String type = this.getClass().getSimpleName();
        type = type.substring(0,type.length() - SUBSTRING_IMPL);
        return String.format("\"%s\" | \"%s\" -> %s%n",
                this.getUsername(),
                this.getHashedPassword(),
                type);
    }
}
