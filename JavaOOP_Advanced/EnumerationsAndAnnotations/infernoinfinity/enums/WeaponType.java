package infernoinfinity.enums;

public enum WeaponType {
    AXE(5, 10, 4),
    SWORD(4, 6, 3),
    KNIFE(3, 4, 2);

    private int minDamage;
    private int maxDamage;
    private int socketHoles;

    private WeaponType(int minDamage, int maxDamage, int socketHoles) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.socketHoles = socketHoles;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getSocketHoles() {
        return socketHoles;
    }
}
