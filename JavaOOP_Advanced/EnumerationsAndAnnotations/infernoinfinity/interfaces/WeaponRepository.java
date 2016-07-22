package infernoinfinity.interfaces;

import infernoinfinity.enums.Gem;
import infernoinfinity.enums.WeaponType;

public interface WeaponRepository {

    void createWeapon(WeaponType weaponType, String weaponName);

    void addGemToSocket(String weaponName, int socketIndex, Gem gemType);

    void removeGemFromSocket(String weaponName, int socketIndex);

    void compareWeapons(String firstWeaponName, String secondWeaponName);

    void printAnnotation(String annotationType);

    void print(String weaponName);
}
