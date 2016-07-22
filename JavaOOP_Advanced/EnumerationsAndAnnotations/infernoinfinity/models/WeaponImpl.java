package infernoinfinity.models;

import infernoinfinity.annotations.CustomInfo;
import infernoinfinity.enums.Gem;
import infernoinfinity.enums.WeaponType;
import infernoinfinity.interfaces.Weapon;

import java.util.Arrays;

@CustomInfo(
        author = "Pesho",
        revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"}
)
public class WeaponImpl implements Weapon, Comparable<Weapon> {

    private static final int MIN_DAMAGE_STRENGTH_BONUS = 2;
    private static final int MAX_DAMAGE_STRENGTH_BONUS = 3;
    private static final int MIN_DAMAGE_AGILITY_BONUS = 1;
    private static final int MAX_DAMAGE_AGILITY_BONUS = 4;

    private String name;
    private WeaponType weaponType;
    private Gem[] sockets;
    private int minDamage;
    private int maxDamage;

    public WeaponImpl(String name, WeaponType weaponType) {
        this.setName(name);
        this.setWeaponType(weaponType);
        this.setMaxDamage(weaponType.getMaxDamage());
        this.setMinDamage(weaponType.getMinDamage());
        this.sockets = new Gem[weaponType.getSocketHoles()];
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    private void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    private void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    private void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    @Override
    public void increaseStats(Gem gemType, int socketIndex) {
        if (isValidIndex(socketIndex)) {
            this.sockets[socketIndex] = gemType;
        }
    }

    @Override
    public void decreaseStats(int socketIndex) {
        if (isValidIndex(socketIndex)) {
            this.sockets[socketIndex] = null;
        }
    }

    @Override
    public int getStrength() {
        return Arrays.stream(this.sockets).filter(e -> e != null).mapToInt(Gem::getStrength).sum();
    }

    @Override
    public int getAgility() {
        return Arrays.stream(this.sockets).filter(e -> e != null).mapToInt(Gem::getAgility).sum();
    }

    @Override
    public int getVitality() {
        return Arrays.stream(this.sockets).filter(e -> e != null).mapToInt(Gem::getVitality).sum();
    }

    @Override
    public int getMinDamage() {
        return this.minDamage + this.getMinDamageBonus();
    }

    @Override
    public int getMaxDamage() {
        return this.maxDamage + this.getMaxDamageBonus();
    }

    public double getItemLevel() {
        return ((this.getMinDamage() + this.getMaxDamage()) / 2.0d) +
                this.getStrength() + this.getAgility() + this.getVitality();
    }

    @Override
    public int compareTo(Weapon otherWeapon) {
        return Double.compare(this.getItemLevel(), otherWeapon.getItemLevel());
    }

    private boolean isValidIndex(int socketIndex) {
        return socketIndex >= 0 && socketIndex < this.weaponType.getSocketHoles();
    }

    private int getMinDamageBonus() {
        return (this.getStrength() * MIN_DAMAGE_STRENGTH_BONUS) + (this.getAgility() * MIN_DAMAGE_AGILITY_BONUS);
    }

    private int getMaxDamageBonus() {
        return (this.getStrength() * MAX_DAMAGE_STRENGTH_BONUS) + (this.getAgility() * MAX_DAMAGE_AGILITY_BONUS);
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(),
                this.getMinDamage(),
                this.getMaxDamage(),
                this.getStrength(),
                this.getAgility(),
                this.getVitality());
    }

}
