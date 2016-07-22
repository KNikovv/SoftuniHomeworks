package infernoinfinity.interfaces;

import infernoinfinity.enums.Gem;

public interface Weapon extends Comparable<Weapon> {

    String getName();

    void increaseStats(Gem gemType, int socketIndex);

    void decreaseStats(int socketIndex);

    int getStrength();

    int getAgility();

    int getVitality();

    int getMinDamage();

    int getMaxDamage();

    double getItemLevel();
}
